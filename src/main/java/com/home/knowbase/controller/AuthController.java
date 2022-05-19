package com.home.knowbase.controller;

import com.home.knowbase.dto.AuthDTO;
import com.home.knowbase.dto.CredentialDTO;
import com.home.knowbase.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public AuthDTO authenticate(@RequestBody CredentialDTO credentialDTO) {
        return authService.authenticate(credentialDTO);
    }
}
