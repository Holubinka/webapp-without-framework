package com.holubinka.service;

import com.holubinka.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getById(Long id);
}
