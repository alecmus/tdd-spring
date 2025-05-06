package com.github.alecmus.tddspring.mapper;

import com.github.alecmus.tddspring.dto.ProjectDTO;
import com.github.alecmus.tddspring.model.Project;
import org.mapstruct.Mapper;

/**
 * @author Alec Musasa
 * @since 06 May 2025
 */
@Mapper
public interface ProjectMapper {
    Project dtoToEntity(ProjectDTO dto);
    ProjectDTO entityToDto(Project entity);
}
