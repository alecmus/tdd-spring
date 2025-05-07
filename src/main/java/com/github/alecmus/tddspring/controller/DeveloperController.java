package com.github.alecmus.tddspring.controller;

import com.github.alecmus.tddspring.dto.DeveloperDTO;
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
public class DeveloperController {

    @PostMapping
    public ResponseEntity<DeveloperDTO> createDeveloper(@RequestBody DeveloperDTO dto) {
        return null;
    }
}
