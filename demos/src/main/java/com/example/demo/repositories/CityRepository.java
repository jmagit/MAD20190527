package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.City;
import com.example.demo.models.Country;

@RepositoryRestResource(exported = false)
public interface CityRepository extends JpaRepository<City, Integer> {
	List<City> findByCountryOrderByCity(Country country);
}
