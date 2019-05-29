package com.example.demo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.contracts.CityService;
import com.example.demo.models.City;
import com.example.demo.models.dtos.CityDTO;

@RestController
@RequestMapping(path = "/ciudades")
public class CityResource {
	@Autowired
	private CityService srv;
	
	@GetMapping
	public List<CityDTO> getAll() {
		return srv.getAll().stream()
				.map(item -> CityDTO.from(item))
				.collect(Collectors.toList());
	}
	
	@GetMapping(path = "/{id}")
	public CityDTO getOne(@PathVariable int id) throws Exception {
		Optional<City> rslt = srv.get(id);
		if(rslt.isEmpty())
			throw new Exception("NOT FOUND");
		return CityDTO.from(rslt.get());
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@Valid CityDTO item) throws Exception {
		srv.add(CityDTO.from(item));
	}
	
	@PutMapping(path = "/{id}")
	public CityDTO change(@PathVariable int id, @Valid CityDTO item) throws Exception {
		//item.setCityId(id);
		if(item.getCityId() != id)
			throw new Exception("BAD REQUEST");
		return CityDTO.from(srv.change(CityDTO.from(item)));
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void change(@PathVariable int id) throws Exception {
		srv.delete(id);
	}
	
	
}
