package com.holubinka.controller;

import com.holubinka.Request;
import com.holubinka.ViewModel;
import com.holubinka.service.CategoryService;

public class GetAllCategoryController implements Controller {

    private final CategoryService categoryService;

    public GetAllCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request req) {
        return ViewModel.of("categories").withAttribute("categories",categoryService.getAll());
    }
}
