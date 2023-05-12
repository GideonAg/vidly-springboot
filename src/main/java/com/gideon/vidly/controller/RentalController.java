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

import com.gideon.vidly.entity.RentalEntity;
import com.gideon.vidly.model.Rental;
import com.gideon.vidly.service.RentalService;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    
    @Autowired
    private RentalService rentalService;

    @PostMapping("")
    public String addRental(@RequestBody Rental rental) {
        return rentalService.addRental(rental);
    }

    @GetMapping("")
    public List<RentalEntity> getRentals() {
        return rentalService.getRentals();
    }

    @GetMapping("/{id}")
    public RentalEntity getRentalById(@PathVariable("id") Long id) {
        return rentalService.getRentalById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRental(@PathVariable("id") Long id) {
        return rentalService.deleteRental(id);
    }
}
