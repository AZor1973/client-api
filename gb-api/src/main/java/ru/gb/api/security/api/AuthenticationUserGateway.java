package ru.gb.api.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gb.api.security.dto.AuthenticationUserDto;

import java.util.HashMap;

public interface AuthenticationUserGateway {

    @PostMapping("/login")
    ResponseEntity<HashMap<Object, Object>> login(@RequestBody AuthenticationUserDto authenticationUserDto);
}
