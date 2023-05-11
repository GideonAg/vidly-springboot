package com.gideon.vidly.service;

import java.util.List;

import com.gideon.vidly.entity.MovieEntity;
import com.gideon.vidly.model.MovieModel;

public interface MovieService {

    List<MovieEntity> getMovies();

    MovieEntity getMovieById(Long id);

    String addMovie(MovieModel movieModel);

    String updateMovie(Long id, MovieModel movieModel);

    String deleteMovie(Long id);
    
}
