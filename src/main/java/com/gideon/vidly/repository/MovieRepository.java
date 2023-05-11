package com.gideon.vidly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gideon.vidly.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

}