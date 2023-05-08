package com.gideon.vidly.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    name = "genre",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"id", "title"}
    )
)
public class GenreEntity {

    @Id
    @SequenceGenerator(
        name = "genre_sequence",
        sequenceName = "genre_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "genre_sequence"
    )
    private Long id;

    @Column(
        nullable = false,
        length = 255
    )
    private String title;
}
