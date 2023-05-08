package com.gideon.vidly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gideon.vidly.entity.GenreEntity;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    List<GenreEntity> findByTitleContaining(String name);

    Optional<GenreEntity> findByTitle(String title);
    
}
