package com.github.alecmus.tddspring.service.impl;

import com.github.alecmus.tddspring.dto.DeveloperDTO;
import com.github.alecmus.tddspring.enums.Specialization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Alec Musasa
 * @since 07 May 2025
 */
@SpringBootTest
@Transactional
class DeveloperServiceImplTest {

    public static DeveloperDTO getTestDeveloperDTO() {
        return DeveloperDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@email.com")
                .specialization(Specialization.BACKEND.name())
                .build();
    }

    @Autowired
    private DeveloperServiceImpl developerService;

    @Test
    void create() {
        var dto = getTestDeveloperDTO();

        // create using the service
        var savedDTO = developerService.create(dto);

        // test presence of automatically generated ID
        assertThat(savedDTO).isNotNull();
        assertThat(savedDTO.getId()).isNotNull();

        // test correctness of persistence
        assertThat(savedDTO.toString()).hasToString(dto.toString());

        // test already exists (to prevent accidental updates via the create method)
        assertThatThrownBy(() -> developerService.create(savedDTO))
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}