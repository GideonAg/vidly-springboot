package com.gideon.vidly.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gideon.vidly.entity.GenreEntity;
import com.gideon.vidly.model.GenreModel;
import com.gideon.vidly.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreEntity> getGenres() {
        List<GenreEntity> genres = genreRepository.findAll();
        return genres;
    }

    @Override
    public List<GenreEntity> getGenreByName(String name) {
        List<GenreEntity> genre = genreRepository.findByTitleContaining(name.trim());
        return genre;
    }

    @Override
    public String addGenre(GenreModel genreModel) {
        Optional<GenreEntity> genre = genreRepository.findByTitle(genreModel.getTitle().trim());
        if (genre.isPresent()) return "Genre already exist";

        if (Objects.nonNull(genreModel.getTitle().trim()) && !"".equalsIgnoreCase(genreModel.getTitle().trim())) {
            GenreEntity genreEntity = new GenreEntity();
            genreEntity.setTitle(genreModel.getTitle().trim());
            genreRepository.save(genreEntity);
            return "Valid";
        }

        return "Invalid";
    }

    @Override
    public String updateGenre(Long id, GenreModel genreModel) {
        Optional<GenreEntity> genre = genreRepository.findById(id);
        if (!genre.isPresent()) return "Invalid";

        if (Objects.nonNull(genreModel.getTitle()) && !"".equalsIgnoreCase(genreModel.getTitle().trim())) {
            genre.get().setTitle(genreModel.getTitle().trim());
            genreRepository.save(genre.get());
            return "Valid";
        }

        return "Invalid";
    }

    @Override
    public String deleteGenre(Long id) {
        Optional<GenreEntity> genre = genreRepository.findById(id);
        if (genre.isPresent()) {
            genreRepository.delete(genre.get());
            return "Valid";
        }

        return "Invalid";
    }
    
}