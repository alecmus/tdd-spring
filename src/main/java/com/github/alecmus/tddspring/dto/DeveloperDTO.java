package com.github.alecmus.tddspring.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Alec Musasa
 * @since 06 May 2025
 */
@Data
@Builder
@ToString
public class DeveloperDTO {
    @ToString.Exclude
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;
}
