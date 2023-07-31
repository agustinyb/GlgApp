package com.glgweb.app.Auth;

import com.glgweb.app.Jwt.JwtService;
import com.glgweb.app.UserModel.Role;
import com.glgweb.app.UserModel.User;
import com.glgweb.app.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public AuthResponse login (LoginRequest request){
        return null;
    }
    public AuthResponse register (RegisterRequest request){
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .role(Role.USER)
                .build();
userRepository.save(user);
return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
    }



}
