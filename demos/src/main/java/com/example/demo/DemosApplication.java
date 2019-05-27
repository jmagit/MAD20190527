package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.ioc.Linea;
import com.example.demo.ioc.Punto;
import com.example.demo.ioc.Servicio;

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
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(p1.toString());
		p1.setX(100);
		System.out.println(p2);
		srv.mensaje();
		System.out.println(valor);
		
	}

}
