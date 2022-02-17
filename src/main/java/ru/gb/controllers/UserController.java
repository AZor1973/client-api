package ru.gb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.api.category.dto.CategoryDto;
import ru.gb.api.product.dto.ProductDto;
import ru.gb.api.security.api.AuthenticationUserGateway;
import ru.gb.api.security.api.UserGateway;
import ru.gb.api.security.dto.AuthenticationUserDto;
import ru.gb.api.security.dto.UserDto;

import java.util.Set;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class UserController {

    private final UserGateway userGateway;
    private final AuthenticationUserGateway authenticationUserGateway;

    @GetMapping("/reg")
    public String showRegForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "reg-form";
    }

    @PostMapping("/reg")
    public String saveUser(UserDto userDto) {
        userGateway.handlePost(userDto);
        return "redirect:/shop/product/all";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new AuthenticationUserDto());
        return "login-form";
    }

    @PostMapping("/login")
    public String login(AuthenticationUserDto authenticationUserDto) {
       authenticationUserGateway.login(authenticationUserDto);
        return "redirect:/shop/product/all";
    }
}
