package com.example.demo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

//@Data @AllArgsConstructor @NoArgsConstructor
@Value
public class FilmShortDTO {
	private int filmId;
	private String title;
}
