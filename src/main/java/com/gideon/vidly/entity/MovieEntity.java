package com.gideon.vidly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
    name = "movie"
)
public class MovieEntity {

    @Id
    @SequenceGenerator(
        name = "movie_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "movie_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int numberInStock;

    @Column(nullable = false)
    private int dailyRentalRate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "genre_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "FK_GENRE_ID")
    )
    private GenreEntity genreEntity;
}
