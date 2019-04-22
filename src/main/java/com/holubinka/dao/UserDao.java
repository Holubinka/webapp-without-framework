package com.holubinka.dao;

import com.holubinka.model.User;

import java.util.Optional;

public interface UserDao {

    User save(User user);

    User getByToken(String token);

    Optional<User> getByUsername(String username);
}
