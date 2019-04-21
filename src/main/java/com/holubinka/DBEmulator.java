package com.holubinka;

import com.holubinka.model.Category;
import com.holubinka.model.Product;
import com.holubinka.model.User;

import java.util.ArrayList;
import java.util.List;

public class DBEmulator {

    private static List<Category> categories = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    static {
        Product product = new Product(1L,"iPhone","Apple product", 999.99);
        Product product2 = new Product(1L, "samsung","korean product", 700.99);
        List<Product> products =new ArrayList<>();
        products.add(product);
        products.add(product2);
        Category category = new Category(1L,"Mobile Phones","Best ever phones");
        category.setProducts(products);
        categories.add(category);
        categories.add(new Category(2L,"Shoes","Italian shoes"));
        categories.add(new Category(3L, "TVs","Chines"));

        users.add(new User(
                5L,
                "vitalik0071",
                "96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e",
                "token1",
                "Vitalik",
                "Holubinka"
        ));
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void addUser(User user){
        users.add(user);
    }
}
