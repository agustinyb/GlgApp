package com.glgweb.app.Auth;

import com.glgweb.app.Jwt.JwtService;
import com.glgweb.app.UserModel.Role;
import com.glgweb.app.UserModel.User;
import com.glgweb.app.UserRepository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login (LoginRequest request){
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
       UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
       String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }
    public AuthResponse register (RegisterRequest request){
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .phonenumber(request.getPhonenumber())
                .email(request.getEmail())
                .role(Role.USER)
                .build();
userRepository.save(user);
return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
    }
}
