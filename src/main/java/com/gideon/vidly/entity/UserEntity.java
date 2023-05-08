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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
    name = "user",
    uniqueConstraints = @UniqueConstraint(
        columnNames = "email"
    )
)
public class UserEntity {
    
    @Id
    @SequenceGenerator(
        name = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    private Long id;

    @Column(
        nullable = false,
        length = 50
    )
    private String firstName;

    @Column(
        nullable = false,
        length = 50
    )
    private String lastName;

    @Column(
        nullable = false,
        length = 255
    )
    private String email;

    @Column(
        length = 60,
        nullable = false
    )
    private String password;

    @Column(nullable = false)
    private boolean isAdmin = false;
    
}
