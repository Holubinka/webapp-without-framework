package com.holubinka.dao;

import com.holubinka.model.Product;

import java.util.List;


public interface ProductDao {

    Product get(Long id);
    List<Product> getAllByCategoryId(Long id);

}
