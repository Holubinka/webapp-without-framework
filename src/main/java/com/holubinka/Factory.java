package com.holubinka;

import com.holubinka.controller.LoginPageController;

public class Factory {
    public static LoginPageController getLoginPageControler() {
        return new LoginPageController();
    }

}
