package com.github.alecmus.tddspring.mapper;

import com.github.alecmus.tddspring.dto.DeveloperDTO;
import com.github.alecmus.tddspring.model.Developer;
import org.mapstruct.Mapper;

/**
 * @author Alec Musasa
 * @since 06 May 2025
 */
@Mapper
public interface DeveloperMapper {
    Developer dtoToEntity(DeveloperDTO dto);
    DeveloperDTO entityToDto(Developer entity);
}
