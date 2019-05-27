package com.example.demo.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("Original")
public class ServicioImpl implements Servicio {
	@Override
	public void mensaje() {
		System.out.println("Hola Mundo");
	}
}
