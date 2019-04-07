package com.holubinka.service;

import com.holubinka.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> authorize(User user);

}
