package com.holubinka.service;

import com.holubinka.model.User;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public Optional<User> authorize(User user) {
        user.setFirstName("Vitalik");
        return Optional.of(user);
    }
}
