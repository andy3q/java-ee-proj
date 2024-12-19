package com.example.nurislam_filmography.service;

import com.example.nurislam_filmography.model.Movie;
import com.example.nurislam_filmography.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Movie existingMovie = getMovieById(id);
        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setDirector(updatedMovie.getDirector());
        existingMovie.setReleaseYear(updatedMovie.getReleaseYear());
        existingMovie.setDuration(updatedMovie.getDuration()); // Added duration update
        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
