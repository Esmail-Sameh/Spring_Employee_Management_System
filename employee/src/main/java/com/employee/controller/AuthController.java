package com.employee.controller;

import com.employee.dtos.SignupRequest;
import com.employee.servise.AuthServise;
import com.employee.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthServise authServise;

    @PostMapping("/signup")
    public ResponseEntity<GlobalResponse<?>> signup(@RequestBody @Valid SignupRequest signupRequest) {
        authServise.signup(signupRequest);
        return new ResponseEntity<>(new GlobalResponse<>("Signed Up"), HttpStatus.CREATED);
    }

}
