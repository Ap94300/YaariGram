package com.example.YaariGram.YarriGram.controller;

import com.example.YaariGram.YarriGram.dto.LoginDto;
import com.example.YaariGram.YarriGram.dto.SignupDto;
import com.example.YaariGram.YarriGram.entities.User;
import com.example.YaariGram.YarriGram.exceptions.UserException;
import com.example.YaariGram.YarriGram.services.AuthService;
import com.example.YaariGram.YarriGram.services.UserService;
import com.example.YaariGram.YarriGram.services.UserUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserUserDetailsService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupDto signupDto) throws UserException {
        User user = userService.registerUser(signupDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);
        return ResponseEntity.ok(token);
    }
}


