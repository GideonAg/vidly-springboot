package com.gideon.vidly.entity;

import java.util.Calendar;
import java.util.Date;

import com.gideon.vidly.model.Customer;
import com.gideon.vidly.model.Movie;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    name = "rental"
)
public class RentalEntity {
    
    @Id
    @SequenceGenerator(
        name = "rental_sequence",
        sequenceName = "rental_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "rental_sequence"
    )
    private Long rentalId;
    
    private Date dateOut;

    private Date dateReturned;

    @Embedded
    private Customer customer;

    @Embedded
    private Movie movie;

    public RentalEntity(Customer customer, Movie movie) {
        this.customer = customer;
        this.movie = movie;
        this.dateOut = Calendar.getInstance().getTime();
    }
}
