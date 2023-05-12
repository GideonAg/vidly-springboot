package com.gideon.vidly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gideon.vidly.entity.RentalEntity;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Long> {
    
}
