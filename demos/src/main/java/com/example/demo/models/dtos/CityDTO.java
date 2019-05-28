package com.example.demo.models.dtos;

import java.io.Serializable;

import com.example.demo.models.City;
import com.example.demo.models.Country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CityDTO implements Serializable {
	private int cityId;
	private String city;
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
