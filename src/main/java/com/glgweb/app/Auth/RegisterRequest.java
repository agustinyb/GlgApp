package com.glgweb.app.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    private LocalDateTime dateCreate= LocalDateTime.now();
    String firstname;
    String lastname;
    Long phonenumber;
    String email;

}
