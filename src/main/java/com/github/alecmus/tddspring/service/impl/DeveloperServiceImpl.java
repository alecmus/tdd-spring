package com.github.alecmus.tddspring.service.impl;

import com.github.alecmus.tddspring.dto.DeveloperDTO;
import com.github.alecmus.tddspring.mapper.DeveloperMapper;
import com.github.alecmus.tddspring.repository.DeveloperRepository;
import com.github.alecmus.tddspring.service.DeveloperService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alec Musasa
 * @since 07 May 2025
 */
@Service
@AllArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Override
    @Transactional
    public DeveloperDTO create(DeveloperDTO dto) {
        if (dto.getId() != null && developerRepository.existsById(dto.getId()))
            throw new DataIntegrityViolationException("Developer with the given ID already exists");

        var entity = developerMapper.dtoToEntity(dto);
        return developerMapper.entityToDto(developerRepository.save(entity));
    }
}
