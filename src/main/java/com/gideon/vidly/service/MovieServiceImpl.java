package com.gideon.vidly.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gideon.vidly.entity.GenreEntity;
import com.gideon.vidly.entity.MovieEntity;
import com.gideon.vidly.model.MovieModel;
import com.gideon.vidly.repository.GenreRepository;
import com.gideon.vidly.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public MovieEntity getMovieById(Long id)  {
        Optional<MovieEntity> movie = movieRepository.findById(id);
        return movie.get();
    }

    @Override
    public String addMovie(MovieModel movieModel) {
        Optional<GenreEntity> genreEntity = genreRepository.findById(movieModel.getGenreId());
        if (!genreEntity.isPresent()) return "Invalid genre ID.";

        MovieEntity movieEntity = MovieEntity.builder()
                                    .name(movieModel.getName())
                                    .numberInStock(movieModel.getNumberInStock())
                                    .dailyRentalRate(movieModel.getDailyRentalRate())
                                    .genreEntity(genreEntity.get())
                                    .build();
                            
        movieRepository.save(movieEntity);
        return "Movie added successfully";
    }

    @Override
    public String updateMovie(Long id, MovieModel movieModel) {
        MovieEntity movieEntity = movieRepository.findById(id).get();
        if (movieEntity == null) return "Invalid movie ID.";

        GenreEntity genreEntity = genreRepository.findById(movieModel.getGenreId()).get();
        if (genreEntity == null) return "Invalid genre ID.";

        if (Objects.nonNull(movieModel.getName()) && !"".equalsIgnoreCase(movieModel.getName())) {
            movieEntity.setName(movieModel.getName());
        }
        if (Objects.nonNull(movieModel.getNumberInStock()) && movieModel.getNumberInStock() > 0) {
            movieEntity.setNumberInStock(movieModel.getNumberInStock());
        }
        if (Objects.nonNull(movieModel.getDailyRentalRate()) && movieModel.getDailyRentalRate() > 0) {
            movieEntity.setDailyRentalRate(movieModel.getDailyRentalRate());
        }
        if (Objects.nonNull(movieModel.getGenreId())) {
            movieEntity.setGenreEntity(genreEntity);
        }

        movieRepository.save(movieEntity);
        return "Movie updated successfully";
    }

    @Override
    public String deleteMovie(Long id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        if (!movieEntity.isPresent()) return "Invalid movie ID.";

        movieRepository.deleteById(id);
        return "Movie deleted successfully";
    }
    
}
