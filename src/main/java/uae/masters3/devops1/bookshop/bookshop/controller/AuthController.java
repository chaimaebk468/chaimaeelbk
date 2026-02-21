package uae.masters3.devops1.bookshop.bookshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uae.masters3.devops1.bookshop.bookshop.dto.LoginRequest;
import uae.masters3.devops1.bookshop.bookshop.dto.LoginResponse;
import uae.masters3.devops1.bookshop.bookshop.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService auth;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req){
        return auth.login(req);
    }
}