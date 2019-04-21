package com.holubinka.dao;

import com.holubinka.model.User;

public interface UserDao {

    User addUser(User user);

    User getByToken(String token);
}
