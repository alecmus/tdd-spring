package com.github.alecmus.tddspring.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Alec Musasa
 * @since 07 May 2025
 */
@Data
@Builder
public class ErrorDTO {
    private String message;
    private int statusCode;
}
