package uae.masters3.devops1.bookshop.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    String token;
}