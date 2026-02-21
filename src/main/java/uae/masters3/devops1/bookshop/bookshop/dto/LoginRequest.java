package uae.masters3.devops1.bookshop.bookshop.dto;

import lombok.Data;

@Data
public class LoginRequest {
    String email;
    String password;
}