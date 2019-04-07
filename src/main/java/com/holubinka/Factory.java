package com.holubinka;

import com.holubinka.controller.GetAllCategoryController;
import com.holubinka.controller.GetCategoryByIdController;
import com.holubinka.controller.LoginUserController;
import com.holubinka.service.CategoryService;
import com.holubinka.service.CategoryServiceImpl;
import com.holubinka.service.UserService;
import com.holubinka.service.UserServiceImpl;

public class Factory {

    public static LoginUserController getLoginUserController(UserService userService) {
        return new LoginUserController(userService);
    }

    public static UserService getUserServiceImpl(){
        return new UserServiceImpl();
    }

    public static GetAllCategoryController getAllCategoryController(CategoryService categoryService){
        return new GetAllCategoryController(categoryService);
    }

    public static CategoryService getCategoryService(){
        return new CategoryServiceImpl();
    }

    public static GetCategoryByIdController getGetCategoryByIdController(CategoryService categoryService){
        return new GetCategoryByIdController(categoryService);
    }
}
