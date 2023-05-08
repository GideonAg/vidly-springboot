package com.gideon.vidly.service;

import java.util.List;

import com.gideon.vidly.entity.GenreEntity;
import com.gideon.vidly.model.GenreModel;

public interface GenreService {

    List<GenreEntity> getGenres();

    List<GenreEntity> getGenreByName(String name);

    String addGenre(GenreModel genreModel);

    String updateGenre(Long id, GenreModel genreModel);

    String deleteGenre(Long id);
    
}
