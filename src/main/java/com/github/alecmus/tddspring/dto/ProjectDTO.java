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
public class ProjectDTO {
    @ToString.Exclude
    private String id;
    private String name;
    private String description;
    private String status;
}
