package com.github.alecmus.tddspring.repository;

import com.github.alecmus.tddspring.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alec Musasa
 * @since 07 May 2025
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
}
