package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.contracts.CityService;
import com.example.demo.models.City;
import com.example.demo.repositories.CityRepository;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository dao;
	@Autowired
	private Validator validator;

	@Override
	public Set<ConstraintViolation<@Valid City>> validate(City item) {
		return validator.validate( item );
	}
	@Override
	public boolean isValid(City item) {
		return validate(item).size() > 0;
	}
	@Override
	public boolean notIsValid(City item) {
		return !isValid(item);
	}
	
	@Override
	public List<City> getAll() {
		return dao.findAll();		
	}
	
	@Override
	public Optional<City> get(int id) {
		return dao.findById(id);
	}
	
	@Override
	public City add(City item) throws Exception {
		if(notIsValid(item))
			throw new Exception("Invalid");
		if(dao.findById(item.getCityId()).isPresent())
			throw new Exception("Duplicate key");
		dao.save(item);
		return item;
	}
	@Override
	public City change(City item) throws Exception {
		if(notIsValid(item))
			throw new Exception("Invalid");
		if(dao.findById(item.getCityId()).isEmpty())
			throw new Exception("Missing item");
		dao.save(item);
		return item;
	}
	@Override
	public void delete(int id) throws Exception {
		try {
			dao.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Missing item", e);
		}
	}
}
