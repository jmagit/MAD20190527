package com.example.demo.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Configuracion {
	@Bean
	@Scope("prototype")
	public Punto punto() {
		Punto rslt = new Punto();
		rslt.setX(200);
		rslt.setY(100);
		return rslt;
	}

}
