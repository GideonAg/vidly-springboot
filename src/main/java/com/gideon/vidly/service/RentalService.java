package com.gideon.vidly.service;

import java.util.List;

import com.gideon.vidly.entity.RentalEntity;
import com.gideon.vidly.model.Rental;

public interface RentalService {

    String addRental(Rental rental);

    List<RentalEntity> getRentals();

    RentalEntity getRentalById(Long id);

    String deleteRental(Long id);
    
}
