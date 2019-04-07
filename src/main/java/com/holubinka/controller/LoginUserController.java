package com.holubinka.controller;

import com.holubinka.Request;
import com.holubinka.ViewModel;
import com.holubinka.model.User;
import com.holubinka.service.UserService;


public class LoginUserController implements Controller {

    private final UserService userService;

    public LoginUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request req) {
        String username = req.getParam("username")[0];
        String password = req.getParam("password")[0];
        User user = User.of(username, password);

       return userService.authorize(user)
               .map(u ->  ViewModel.of("welcome").withAttribute("user",u))
               .orElseGet(() -> ViewModel.of("login").withAttribute("error","msg"));
    }
}
