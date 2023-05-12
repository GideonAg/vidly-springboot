package com.gideon.vidly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gideon.vidly.entity.CustomerEntity;
import com.gideon.vidly.entity.MovieEntity;
import com.gideon.vidly.entity.RentalEntity;
import com.gideon.vidly.entity.UserEntity;
import com.gideon.vidly.model.Customer;
import com.gideon.vidly.model.Movie;
import com.gideon.vidly.model.Rental;
import com.gideon.vidly.repository.CustomerRepository;
import com.gideon.vidly.repository.MovieRepository;
import com.gideon.vidly.repository.RentalRepository;
import com.gideon.vidly.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RentalServiceImpl implements RentalService{

    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addRental(Rental rental) {
        Optional<UserEntity> retrievedUser = userRepository.findById(rental.getUserId());
        if (!retrievedUser.isPresent()) return "Invalid user ID.";

        Optional<MovieEntity> retrievedMovie = movieRepository.findById(rental.getMovieId());
        if (!retrievedMovie.isPresent()) return "Invalid movie ID.";

        if (retrievedMovie.get().getNumberInStock() < 1) return "Movie not in stock.";

        CustomerEntity customer = CustomerEntity.builder()
                            .customerFirstName(retrievedUser.get().getFirstName())
                            .customerLastName(retrievedUser.get().getLastName())
                            .build();
        
        customerRepository.save(customer);

        Movie movie2 = Movie.builder()
                        .movieId(retrievedMovie.get().getId())
                        .name(retrievedMovie.get().getName())
                        .dailyRentalRate(retrievedMovie.get().getDailyRentalRate())
                        .build();

        Customer customer2 = Customer.builder()
                            .customerFirstName(retrievedUser.get().getFirstName())
                            .customerLastName(retrievedUser.get().getLastName())
                            .build();

        retrievedMovie.get().setNumberInStock(retrievedMovie.get().getNumberInStock() - 1);
        movieRepository.save(retrievedMovie.get());

        RentalEntity rentalEntity = new RentalEntity(customer2, movie2);

        rentalRepository.save(rentalEntity);
        
        return "Rental created successfully";
    }

    @Override
    public List<RentalEntity> getRentals() {
        List<RentalEntity> list = rentalRepository.findAll();
        return list;
    }

    @Override
    public RentalEntity getRentalById(Long id) {
        Optional<RentalEntity> rental = rentalRepository.findById(id);
        return rental.get();
    }

    @Override
    public String deleteRental(Long id) {
        Optional<RentalEntity> rental = rentalRepository.findById(id);
        if (!rental.isPresent()) return "Invalid rental ID.";
        rentalRepository.deleteById(id);
        return "Rental deleted successfully";
    }
    
}
