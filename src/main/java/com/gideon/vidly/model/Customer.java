package com.gideon.vidly.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private String customerFirstName;
    private String customerLastName;
    private boolean isGold = false;
}
