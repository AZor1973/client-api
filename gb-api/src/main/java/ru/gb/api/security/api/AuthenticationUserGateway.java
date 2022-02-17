package ru.gb.api.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gb.api.security.dto.AuthenticationUserDto;

public interface AuthenticationUserGateway {

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthenticationUserDto authenticationUserDto);
}
