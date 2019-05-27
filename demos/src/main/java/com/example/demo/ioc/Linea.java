package com.example.demo.ioc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Linea {
	@Autowired
	private Punto p1;
	@Autowired
	private Punto p2;

	public Linea() {
	}
	
	@PostConstruct
	private void inicia() {
		System.out.println(p1.toString());
		System.out.println(p2);
	}
}
