package uae.masters3.devops1.bookshop.bookshop.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private Integer stock;
    private String description;
    private String categoryName; // On renvoie juste le nom pour simplifier le JSON
}
