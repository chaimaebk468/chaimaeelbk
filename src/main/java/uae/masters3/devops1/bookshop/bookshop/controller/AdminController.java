package uae.masters3.devops1.bookshop.bookshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import uae.masters3.devops1.bookshop.bookshop.dto.BookAdminRequest;
import uae.masters3.devops1.bookshop.bookshop.entity.Book;
import uae.masters3.devops1.bookshop.bookshop.entity.Category;
import uae.masters3.devops1.bookshop.bookshop.repository.BookRepository;
import uae.masters3.devops1.bookshop.bookshop.repository.CategoryRepository;

@RestController
@RequestMapping("/api/admin/books")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    // 1️⃣ Ajouter un livre
    @PostMapping
    public Book addBook(@RequestBody BookAdminRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setCategory(category);

        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());
        book.setStock(request.getStock());
        book.setDescription(request.getDescription());

        return bookRepository.save(book);
    }

    // 2️⃣ Supprimer un livre
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}