package com.example.demo.contracts;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;

import com.example.demo.models.City;

public interface CityService {

	Set<ConstraintViolation<@Valid City>> validate(City item);

	boolean isValid(City item);

	boolean notIsValid(City item);

	List<City> getAll();

	Optional<City> get(int id);

	City add(City item) throws Exception;

	City change(City item) throws Exception;

	void delete(int id) throws Exception;

}