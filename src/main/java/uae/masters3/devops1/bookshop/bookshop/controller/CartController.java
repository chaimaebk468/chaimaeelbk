package uae.masters3.devops1.bookshop.bookshop.controller;


import uae.masters3.devops1.bookshop.bookshop.dto.CartItemRequest;
import uae.masters3.devops1.bookshop.bookshop.dto.CartResponse;
import uae.masters3.devops1.bookshop.bookshop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public CartResponse getCart() {
        return cartService.getCartForCurrentUser();
    }

    @PostMapping("/items")
    public CartResponse addItem(@RequestBody CartItemRequest request) {
        return cartService.addItemToCart(request);
    }

    @PutMapping("/items/{id}")
    public CartResponse updateItem(@PathVariable Long id, @RequestBody CartItemRequest request) {
        return cartService.updateCartItem(id, request);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        cartService.removeCartItem(id);
    }
}