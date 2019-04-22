package com.holubinka.service;

import com.holubinka.dao.CategoryDao;
import com.holubinka.model.Category;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Optional<Category> getById(Long id) {
        return Optional.ofNullable(categoryDao.getCategoryById(id));
    }
}
