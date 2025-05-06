package com.github.alecmus.tddspring.model;

import com.github.alecmus.tddspring.enums.Specialization;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

/**
 * @author Alec Musasa
 * @since 06 May 2025
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "developer")
public class Developer {
    @Id
    @UuidGenerator
    @Column(length = 36, updatable = false, nullable = false)
    private String id;

    @ToString.Include
    @Column(nullable = false)
    private String firstName;

    @ToString.Include
    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;
}
