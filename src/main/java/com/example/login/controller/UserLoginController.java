package com.example.login.controller;

import com.example.login.dto.LoginRequest;
import com.example.login.model.UserLogin;
import com.example.login.service.UserLoginService;
import com.example.login.util.ResponseLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequest loginRequest) {
        UserLogin register = userLoginService.register(loginRequest);
        return new ResponseEntity<>(register, HttpStatus.resolve(HttpStatus.OK.value()));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            Optional<UserLogin> userLogin = userLoginService.login(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok("Login berhasil");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login gagal : " + e.getMessage());
        }
    }
}
