package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Film;

public interface FilmRepositoy extends JpaRepository<Film, Integer> {
	List<Film> findTop10ByTitleStartingWithAndRentalDurationBetween(String titulo, byte min, byte max );
	<T> List<T> findByTitleStartingWith(String titulo, Class<T> type);
}
