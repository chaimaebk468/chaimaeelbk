package uae.masters3.devops1.bookshop.bookshop.dto;


import jakarta.validation.constraints.*; // Pour la validation obligatoire
import lombok.Data;

@Data
public class BookRequest {

    @NotBlank(message = "Le titre est obligatoire")
    private String title;

    @NotBlank(message = "L'auteur est obligatoire")
    private String author;

    @Positive(message = "Le prix doit être positif")
    private Double price;

    @Min(value = 0, message = "Le stock ne peut pas être négatif")
    private Integer stock;

    private String description;

    @NotNull(message = "L'ID de la catégorie est obligatoire")
    private Long categoryId;
}
