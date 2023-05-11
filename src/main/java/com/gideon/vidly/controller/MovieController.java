package com.gideon.vidly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gideon.vidly.entity.MovieEntity;
import com.gideon.vidly.model.MovieModel;
import com.gideon.vidly.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;
    
    @GetMapping("")
    public List<MovieEntity> getMovies() {
        List<MovieEntity> movies = movieService.getMovies();
        return movies;
    }

    @GetMapping("/{id}")
    public MovieEntity getMovieById(@PathVariable("id") Long id) {
        MovieEntity movie = movieService.getMovieById(id);
        return movie;
    }

    @PostMapping("")
    public String addMovie(@RequestBody MovieModel movieModel) {
        String response = movieService.addMovie(movieModel);
        return response;
    }

    @PostMapping("/{id}")
    public String updateMovie(@PathVariable("id") Long id, @RequestBody MovieModel movieModel) {
        String response = movieService.updateMovie(id, movieModel);
        return response;
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        String response = movieService.deleteMovie(id);
        return response;
    }
}
