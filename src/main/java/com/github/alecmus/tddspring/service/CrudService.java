package com.github.alecmus.tddspring.service;

/**
 * @author Alec Musasa
 * @since 07 May 2025
 */
public interface CrudService<T> {
    T create(T dto);
}
