package com.example.jwt.controller;



import com.example.jwt.dto.LoginRequest;
import com.example.jwt.dto.RegisterRequest;
import com.example.jwt.dto.JwtResponse;
import com.example.jwt.lib.ResSend;
import com.example.jwt.model.Auth;
import com.example.jwt.model.User;
import com.example.jwt.repository.AuthRepository;
import com.example.jwt.security.JwtTokenProvider;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth2")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    AuthRepository authRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {
        if (userService.existsByUsername(registerRequest.getUsername())) {
            return "Username is already taken!";
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());

        userService.saveUser(user);

        return "User registered successfully!";
    }

    @PostMapping("/login")
    public ResponseEntity<ResSend> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println(23456);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        System.out.println(authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication, loginRequest);
       // System.out.println(jwt);
       // return new JwtResponse(jwt);
        List<Auth> auth = authRepository.findByVendorCode(loginRequest.getUsername());
        Map<String, Object> data = new HashMap<>();
        data.put("user", auth.get(0));

        Map<String, String> token = new HashMap<>();
        token.put("accessToken", jwt);

        ResSend resData = new ResSend(true, 200, "User authentication successfully.", data, token);
        return new ResponseEntity<ResSend>(resData, HttpStatus.OK);
    }
}

