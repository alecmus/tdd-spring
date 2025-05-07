package com.github.alecmus.tddspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alecmus.tddspring.dto.DeveloperDTO;
import com.github.alecmus.tddspring.enums.Specialization;
import com.github.alecmus.tddspring.service.DeveloperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Alec Musasa
 * @since 07 May 2025
 */
@WebMvcTest(DeveloperController.class)
class DeveloperControllerTest {

    public static DeveloperDTO getTestDeveloperDTO() {
        return DeveloperDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@email.com")
                .specialization(Specialization.BACKEND.name())
                .build();
    }

    public static DeveloperDTO cloneDeveloperDTO(DeveloperDTO dto) {
        return DeveloperDTO.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .specialization(dto.getSpecialization())
                .build();
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DeveloperService developerService;

    @TestConfiguration
    static class MockConfig {
        @Bean
        @Primary
        public DeveloperService developerService() {
            return mock(DeveloperService.class);
        }
    }

    @BeforeEach
    void resetMocks() {
        Mockito.reset(developerService);
    }

    @Test
    void createDeveloper() throws Exception {
        var requestDTO = getTestDeveloperDTO();
        var responseDTO = cloneDeveloperDTO(requestDTO);
        responseDTO.setId("some_id");

        // mock the service layer
        given(developerService.create(requestDTO))
                .willReturn(responseDTO);

        // test the endpoint
        mockMvc.perform(post("/developer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(responseDTO)));

        // verify that the mock was used
        verify(developerService).create(requestDTO);
    }

    @Test
    void createDeveloperDuplicateId() throws Exception {
        var requestDTO = getTestDeveloperDTO();

        // mock the service layer
        given(developerService.create(requestDTO))
                .willThrow(DataIntegrityViolationException.class);

        // test the endpoint
        mockMvc.perform(post("/developer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isConflict());

        // verify that the mock was used
        verify(developerService).create(requestDTO);
    }
}
