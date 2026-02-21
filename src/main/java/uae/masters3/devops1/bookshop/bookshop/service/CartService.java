package uae.masters3.devops1.bookshop.bookshop.service;



import uae.masters3.devops1.bookshop.bookshop.dto.CartItemRequest;
import uae.masters3.devops1.bookshop.bookshop.dto.CartItemResponse;
import uae.masters3.devops1.bookshop.bookshop.dto.CartResponse;
import uae.masters3.devops1.bookshop.bookshop.entity.Book;
import uae.masters3.devops1.bookshop.bookshop.entity.CartItem;
import uae.masters3.devops1.bookshop.bookshop.entity.User;
import uae.masters3.devops1.bookshop.bookshop.repository.BookRepository;
import uae.masters3.devops1.bookshop.bookshop.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;

    private User getCurrentUser() {
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public CartResponse getCartForCurrentUser() {

        User user = getCurrentUser();

        List<CartItem> items = cartItemRepository.findByUser(user);

        List<CartItemResponse> itemResponses = items
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        double total = itemResponses
                .stream()
                .mapToDouble(CartItemResponse::getTotalPrice)
                .sum();

        return CartResponse.builder()
                .items(itemResponses)
                .totalAmount(total)
                .build();
    }

    public CartResponse addItemToCart(CartItemRequest request) {

        User user = getCurrentUser();

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getStock() < request.getQuantity()) {
            throw new RuntimeException("Not enough stock available");
        }

        CartItem item = CartItem.builder()
                .user(user)
                .book(book)
                .quantity(request.getQuantity())
                .unitPrice(book.getPrice())
                .build();

        cartItemRepository.save(item);

        return getCartForCurrentUser();
    }

    public CartResponse updateCartItem(Long cartItemId, CartItemRequest request) {

        User user = getCurrentUser();

        CartItem item = cartItemRepository
                .findByIdAndUser(cartItemId, user)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        if (item.getBook().getStock() < request.getQuantity()) {
            throw new RuntimeException("Not enough stock available");
        }

        item.setQuantity(request.getQuantity());

        cartItemRepository.save(item);

        return getCartForCurrentUser();
    }

    public void removeCartItem(Long cartItemId) {

        User user = getCurrentUser();

        CartItem item = cartItemRepository
                .findByIdAndUser(cartItemId, user)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        cartItemRepository.delete(item);
    }

    private CartItemResponse mapToResponse(CartItem item) {

        return CartItemResponse.builder()
                .id(item.getId())
                .bookTitle(item.getBook().getTitle())
                .quantity(item.getQuantity())
                .unitPrice(item.getUnitPrice())
                .totalPrice(item.getUnitPrice() * item.getQuantity())
                .build();
    }
}