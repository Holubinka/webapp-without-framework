package com.holubinka.model;

import com.holubinka.annotations.Table;

@Table(name = "PRODUCTS")
public class Product {
    private Long id;
    private String productsName;
    private String productsDescription;
    private double price;

    public Product(Long id,String productsName, String productsDescription, double price) {
        this.id = id;
        this.productsName = productsName;
        this.productsDescription = productsDescription;
        this.price = price;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productsName;
    }

    public void setProductName(String productName) {
        this.productsName = productName;
    }

    public String getDescription() {
        return productsDescription;
    }

    public void setDescription(String description) {
        this.productsDescription = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
