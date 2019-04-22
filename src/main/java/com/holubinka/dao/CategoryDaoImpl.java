package com.holubinka.dao;

import com.holubinka.model.Category;
import com.holubinka.model.Product;

import java.sql.Connection;
import java.util.List;

import static com.holubinka.Factory.getConnection;
import static com.holubinka.Factory.getProductDao;

public class CategoryDaoImpl extends AbstractDao<Category,Long> implements CategoryDao {

    public CategoryDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Category getById(Long id) {
        Category category = get(id);
        List<Product> products = getProductDao(getConnection()).getAllByCategoryId(id);
        category.setProducts(products);
        return category;
    }

}
