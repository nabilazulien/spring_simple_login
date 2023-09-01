package com.example.login.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
