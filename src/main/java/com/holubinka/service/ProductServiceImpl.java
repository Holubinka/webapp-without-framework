package com.holubinka.service;

import com.holubinka.dao.ProductDao;
import com.holubinka.model.Product;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Optional<Product> getById(Long id) {
        return Optional.ofNullable(productDao.getProductById(id));
    }
}
