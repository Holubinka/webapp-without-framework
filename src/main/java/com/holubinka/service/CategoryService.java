package com.holubinka.service;

import com.holubinka.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAll();
    Optional<Category> getById(Long id);
}
