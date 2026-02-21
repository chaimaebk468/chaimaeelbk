package uae.masters3.devops1.bookshop.bookshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uae.masters3.devops1.bookshop.bookshop.dto.LoginRequest;
import uae.masters3.devops1.bookshop.bookshop.dto.LoginResponse;
import uae.masters3.devops1.bookshop.bookshop.entity.User;
import uae.masters3.devops1.bookshop.bookshop.repository.UserRepository;
import uae.masters3.devops1.bookshop.bookshop.security.JwtService;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public LoginResponse login(LoginRequest req) {

        User user = repo.findByEmail(req.getEmail())
                .orElseThrow();

        if(!encoder.matches(req.getPassword(), user.getPassword()))
            throw new RuntimeException("bad credentials");

        String token = jwt.generateToken(user);

        return new LoginResponse(token);
    }
}