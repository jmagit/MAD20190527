package com.example.demo.models.dtos;

import java.io.Serializable;

import javax.validation.constraints.Size;

import com.example.demo.models.City;
import com.example.demo.models.Country;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@ApiModel(value = "Edicion de Ciudades", description = "Datos de las ciudades ....")
public class CityDTO implements Serializable {
	@ApiModelProperty(name = "Identificador de Ciudad", 
			notes = "Se genara automaticamente",
			required = true,
			readOnly = true)
	private int cityId;
	@Size(max = 50, min = 2)
	@ApiModelProperty(name = "Nombre de la Ciudad", 
			notes = "la longitud debe estar entre los 2 y 50 caracteres",
			required = true)
	private String city;
	@ApiModelProperty(name = "Identificador de Paid", 
			required = true)
	private int countryId;

	public static CityDTO from(City source) {
		return new CityDTO(
				source.getCityId(),
				source.getCity(),
				source.getCountry() == null ? -1 : source.getCountry().getCountryId()
				);
	}
	public static City from(CityDTO source) {
		return new City(
				source.getCityId(),
				source.getCity(),
				source.getCountryId() == -1 ? null : new Country(source.getCountryId())
				);
	}
}
