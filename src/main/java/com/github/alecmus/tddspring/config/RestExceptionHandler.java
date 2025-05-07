package com.github.alecmus.tddspring.config;

import com.github.alecmus.tddspring.dto.ErrorDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Alec Musasa
 * @since 07 May 2025
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDTO> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .message("Data integrity violation: " + ex.getMostSpecificCause().getMessage())
                .statusCode(HttpStatus.CONFLICT.value())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDTO);
    }
}
