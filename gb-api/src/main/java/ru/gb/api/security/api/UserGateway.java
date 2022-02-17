package ru.gb.api.security.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.security.dto.UserDto;

import java.util.List;

public interface UserGateway {

    @GetMapping
    List<UserDto> getUserList();

    @GetMapping("/{userId}")
    ResponseEntity<?> getUser(@PathVariable("userId") Long id);

    @PostMapping
    ResponseEntity<?> handlePost(@Validated @RequestBody UserDto userDto);

    @PutMapping("/{userId}")
    ResponseEntity<?> handleUpdate(@PathVariable("userId") Long id,
                                          @Validated @RequestBody UserDto userDto);

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("userId") Long id);


}
