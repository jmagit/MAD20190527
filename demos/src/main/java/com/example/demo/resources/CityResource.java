package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.contracts.CityService;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.City;
import com.example.demo.models.Country;
import com.example.demo.models.dtos.CityDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/ciudades")
@Api(value = "Mantenimiento de ciudades")
public class CityResource {
	@Autowired
	private CityService srv;
	
	@GetMapping
	public Page<City> getAll(Pageable pageable) {
		return srv.getAll(pageable); //.stream()
//				.map(item -> CityDTO.from(item))
//				.collect(Collectors.toList());
	}
	
	@GetMapping(path = "/{id}")
	public CityDTO getOne(@PathVariable int id) throws Exception {
		Optional<City> rslt = srv.get(id);
		if(rslt.isEmpty())
			throw new NotFoundException();
		return CityDTO.from(rslt.get());
	}
	
	@GetMapping(path = "/{id}/pais")
	@Transactional
	@ApiOperation(value = "Recupera el pais asociado a la ciudad")
	@ApiParam(name = "id", value = "Identificador de la ciudad")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Pais encontrado"),
		@ApiResponse(code = 404, message = "Pais no encontrado")
	})
	public Country getCountry(@PathVariable int id) throws Exception {
		Optional<City> rslt = srv.get(id);
		if(rslt.isEmpty())
			throw new NotFoundException();
		return rslt.get().getCountry();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Object> add(@Valid @RequestBody CityDTO item) throws Exception {
		City rsltCity = srv.add(CityDTO.from(item));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(rsltCity.getCityId()).toUri();
			return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path = "/{id}")
	public CityDTO change(@PathVariable int id, @Valid @RequestBody CityDTO item) throws Exception {
		//item.setCityId(id);
		if(item.getCityId() != id)
			throw new BadRequestException("No coinciden los ID");
		return CityDTO.from(srv.change(CityDTO.from(item)));
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void change(@PathVariable int id) throws Exception {
		srv.delete(id);
	}
	
	
}
