package com.example.nurislam_filmography.repository;

import com.example.nurislam_filmography.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
