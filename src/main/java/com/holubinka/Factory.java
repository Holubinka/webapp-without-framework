package com.holubinka;

import com.holubinka.controller.GetAllCategoryController;
import com.holubinka.controller.GetCategoryByIdController;
import com.holubinka.controller.GetProductByIdController;
import com.holubinka.controller.LoginUserController;
import com.holubinka.dao.CategoryDao;
import com.holubinka.dao.CategoryDaoImpl;
import com.holubinka.dao.ProductDao;
import com.holubinka.dao.ProductDaoImpl;
import com.holubinka.dao.UserDao;
import com.holubinka.dao.UserDaoImpl;
import com.holubinka.service.CategoryService;
import com.holubinka.service.CategoryServiceImpl;
import com.holubinka.service.ProductService;
import com.holubinka.service.ProductServiceImpl;
import com.holubinka.service.UserService;
import com.holubinka.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static LoginUserController getLoginUserController(UserService userService) {
        return new LoginUserController(userService);
    }

    public static UserService getUserServiceImpl(UserDao userDao) {
        return new UserServiceImpl(userDao);
    }

    public static UserDao getUserDaoImpl(Connection connection) {
        return new UserDaoImpl(connection);
    }

    public static GetAllCategoryController getAllCategoryController(CategoryService categoryService) {
        return new GetAllCategoryController(categoryService);
    }

    public static CategoryService getCategoryService(CategoryDao categoryDao) {
        return new CategoryServiceImpl(categoryDao);
    }

    public static CategoryDao getCategoryDao(Connection connection) {
        return new CategoryDaoImpl(connection);
    }

    public static GetCategoryByIdController getGetCategoryByIdController(CategoryService categoryService) {
        return new GetCategoryByIdController(categoryService);
    }

    public  static ProductService getProductService(ProductDao productDao) {
        return new ProductServiceImpl(productDao);
    }
    public static ProductDao getProductDao(Connection connection) {
        return new ProductDaoImpl(connection);
    }

    public static GetProductByIdController getGetProductByIdController(ProductService productService) {
        return new GetProductByIdController(productService);
    }
}
