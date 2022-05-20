package com.home.knowbase.security;

import com.home.knowbase.dto.CredentialDTO;
import com.home.knowbase.dto.UserDTO;
import com.home.knowbase.dto.UserTokenDTO;
import com.home.knowbase.enums.Role;
import com.home.knowbase.service.UserService;
import com.home.knowbase.service.UserTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final UserTokenService userTokenService;
    private final PasswordEncoder passwordEncoder;

    public UserTokenDTO authenticate(CredentialDTO credential) {

        UserDTO user = userService.getUserByLogin(credential.login())
                .orElseThrow(RuntimeException::new);

        String st = passwordEncoder.encode("qwerty");

        if (!passwordEncoder.matches(credential.password(), user.password())) {
            throw new RuntimeException();
        }

        return userTokenService.getTokenByUserId(user.id())
                .orElseGet(() -> userTokenService.putNewToken(user.id()));
    }

    public Authentication getAuthentication(UUID token) {
        Optional<UserDTO> user = userService.getUserByToken(token);

        if (user.isEmpty()) {
            return null;
        }

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(Role.USER.name()));
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }
}
