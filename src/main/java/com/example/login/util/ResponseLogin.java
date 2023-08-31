package com.example.login.util;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseLogin {
    private String Code;
    private String Msg;
    private Object Data;
}
