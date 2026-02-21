package uae.masters3.devops1.bookshop.bookshop.dto; // Vérifiez le package

import lombok.Data;

@Data
public class RegisterRequest {

    private String email;
    private String password;

}