package com.holubinka.controller;

import com.holubinka.Request;
import com.holubinka.ViewModel;

public class LoginPageController implements Controller {
    @Override
    public ViewModel process(Request req) {
        return ViewModel.of("login");
    }
}
