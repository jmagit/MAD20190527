package com.example.demo.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("actual")
public class Despedida implements Servicio {

	@Override
	public void mensaje() {
		System.out.println("Adios Mundo");
	}

}
