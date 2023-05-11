package com.gideon.vidly.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieModel {
    private String name;
    private int numberInStock;
    private int dailyRentalRate;
    private Long genreId;
}
