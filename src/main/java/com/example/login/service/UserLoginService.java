package com.example.login.service;

import com.example.login.model.UserLogin;

import java.util.Optional;

public interface UserLoginService {
    Optional<UserLogin> login(String username, String password);
}
