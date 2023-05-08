package com.gideon.vidly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gideon.vidly.entity.GenreEntity;
import com.gideon.vidly.model.GenreModel;
import com.gideon.vidly.service.GenreService;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;
    
    @GetMapping("")
    public List<GenreEntity> getGenres() {
        List<GenreEntity> genres = genreService.getGenres();
        return genres;
    }

    @GetMapping("/{name}")
    public List<GenreEntity> getGenreByName(@PathVariable("name") String name) {
        List<GenreEntity> genre = genreService.getGenreByName(name);
        return genre;
    }

    @PostMapping("")
    public String addGenre(@RequestBody GenreModel genreModel) {
        String result = genreService.addGenre(genreModel);
        if (result.equalsIgnoreCase("Valid")) return "Genre added successfully";
        return "Genre already exist";
    }

    @PutMapping("/{id}")
    public String updateGenre(@PathVariable("id") Long id, @RequestBody GenreModel genreModel) {
        String result = genreService.updateGenre(id, genreModel);
        if (result.equalsIgnoreCase("Valid")) return "Genre update successful";
        return "Invalid genre update";
    }

    @DeleteMapping("/{id}")
    public String deleteGenre(@PathVariable("id") Long id) {
        String result = genreService.deleteGenre(id);
        if (result.equalsIgnoreCase("Valid")) return "Genre deleted successfully";
        return "Invalid genre ID";
    }
}
