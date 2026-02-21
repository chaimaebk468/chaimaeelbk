package uae.masters3.devops1.bookshop.bookshop.dto;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemRequest {
    private Long bookId;
    private Integer quantity;
}