package com.example.login.service;

import com.example.login.dto.LoginRequest;
import com.example.login.model.UserLogin;
import com.example.login.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UserLoginService{

    @Autowired
    UserLoginRepository userLoginRepository;

    @Override
    public UserLogin register(LoginRequest loginRequest) {
        Optional<UserLogin> username = userLoginRepository.findByUsername(loginRequest.getUsername());
        if (username.isPresent()) {
            return null;
        }
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(loginRequest.getUsername());
        userLogin.setPassword(loginRequest.getPassword());
        userLoginRepository.save(userLogin);
        return userLogin;
    }

    @Override
    public Optional<UserLogin> login(String username, String password) {
        Optional<UserLogin> userLogin = userLoginRepository.findByUsername(username);
        if (userLogin == null) {
            throw new RuntimeException("Username tidak sesuai");
        }
        if (!password.equals(password)) {
            throw new RuntimeException("Password tidak sesuai");
        }
        return userLogin;
    }
}
