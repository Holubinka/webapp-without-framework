package com.holubinka.dao;

import com.holubinka.model.Category;

import java.util.List;

public interface CategoryDao {

    Category getById(Long id);

    List<Category> getAll();
}
