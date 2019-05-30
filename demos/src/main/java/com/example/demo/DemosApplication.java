package com.example.demo;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.contracts.CityService;
import com.example.demo.ioc.Linea;
import com.example.demo.ioc.Punto;
import com.example.demo.ioc.Servicio;
import com.example.demo.models.City;
import com.example.demo.models.Country;
import com.example.demo.models.dtos.CityDTO;
import com.example.demo.models.dtos.FilmShortDTO;
import com.example.demo.repositories.CityRepository;
import com.example.demo.repositories.FilmRepositoy;
import com.example.demo.services.CityServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class DemosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemosApplication.class, args);
	}

	@Autowired
	private Punto p1;
	@Autowired
	private Punto p2;
	@Autowired
	private Linea linea;
	
	@Autowired
	@Qualifier("actual")
	private Servicio srv;
	
	@Value("${mi.valor.de.ejemplo}")
	private String valor;
	
//	@Autowired
//	private CityRepository dao;
	@Autowired
	private CityService srvDom;
	@Autowired
	private FilmRepositoy pelis;

	@Autowired
	private Validator validator;

	@Override
//	@Transactional
	public void run(String... args) throws Exception {
//		System.out.println(p1.toString());
//		p1.setX(100);
//		System.out.println(p2);
//		srv.mensaje();
//		System.out.println(valor);
		
//		City city = new City(666, "Madrid", new Country(87));
//		CityDTO cityDTO = new CityDTO(666, "M", 87);
//		Set<ConstraintViolation<@Valid CityDTO>> valDTO =  
//				validator.validate( cityDTO );
//		City city = CityDTO.from(cityDTO);
//		Set<ConstraintViolation<@Valid City>> constraintViolations =  
//				validator.validate( city );
//		if (constraintViolations.size() > 0)
//			constraintViolations.forEach(item->System.out.println("ERROR: " + item));
//		else
//			dao.save(city);
//		dao.deleteById(666);
//		dao.findByCountryOrderByCity(new Country(87)).stream()
//			.map(item -> CityDTO.from(item))
//			.forEach(item -> System.out.println(item));
//		Optional<City> rslt = dao.findById(666);
//		if(rslt.isPresent())
//			System.out.println("Encontrada; " + rslt.get().getCountry().getCountry());
//		pelis.findTop10ByTitleStartingWithAndRentalDurationBetween("a", (byte)2, (byte)5).stream()
//			.forEach(item -> System.out.println(item));
//		pelis.findByTitleStartingWith("", FilmShortDTO.class).stream()
//			.forEach(item -> System.out.println(item));
//		srvDom.getAll().stream()
//		.map(item -> CityDTO.from(item))
//		.forEach(item -> System.out.println(item));
//		City city = srvDom.get(1).get();
//		city.getAddresses().get(0).getCustomers().forEach(
//				item -> System.out.println(item));
	}

}
