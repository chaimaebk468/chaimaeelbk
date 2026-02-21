package uae.masters3.devops1.bookshop.bookshop.dto;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemResponse {
    private Long id;
    private String bookTitle;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
}