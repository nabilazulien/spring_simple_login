package com.example.login.service;

import com.example.login.dto.LoginRequest;
import com.example.login.model.UserLogin;

import java.util.Optional;

public interface UserLoginService {
    public UserLogin register(LoginRequest loginRequest);
    Optional<UserLogin> login(String username, String password);
}
