package uae.masters3.devops1.bookshop.bookshop.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uae.masters3.devops1.bookshop.bookshop.dto.BookResponse;
import uae.masters3.devops1.bookshop.bookshop.dto.CategoryResponse;
import uae.masters3.devops1.bookshop.bookshop.service.BookService;
import uae.masters3.devops1.bookshop.bookshop.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/public") // Route de base pour le public (sans sécurité)
@RequiredArgsConstructor // Génère le constructeur pour l'injection des services
public class PublicController {

    private final BookService bookService;
    private final CategoryService categoryService;

    // 1. Récupérer toutes les catégories
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // 2. Récupérer tous les livres avec pagination
    // Exemple : /api/public/books?page=0&size=10
    @GetMapping("/books")
    public ResponseEntity<Page<BookResponse>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bookService.getAllBooks(page, size));
    }

    // 3. Récupérer les détails d'un livre par son ID
    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
}
