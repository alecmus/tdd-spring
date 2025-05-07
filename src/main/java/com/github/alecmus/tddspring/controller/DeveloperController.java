package com.github.alecmus.tddspring.controller;

import com.github.alecmus.tddspring.dto.DeveloperDTO;
import com.github.alecmus.tddspring.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alec Musasa
 * @since 07 May 2025
 */
@RestController
@RequestMapping("/developer")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping
    public ResponseEntity<DeveloperDTO> createDeveloper(@RequestBody DeveloperDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(developerService.create(dto));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(null);
        }
    }
}
