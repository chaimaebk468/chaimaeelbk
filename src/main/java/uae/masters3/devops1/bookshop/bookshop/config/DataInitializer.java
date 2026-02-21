package uae.masters3.devops1.bookshop.bookshop.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uae.masters3.devops1.bookshop.bookshop.entity.*;
import uae.masters3.devops1.bookshop.bookshop.repository.*;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        // éviter de recréer les données à chaque redémarrage
        if (userRepository.count() > 0) {
            return;
        }

        // ================= USERS =================
        User admin = User.builder()
                .email("admin@gmail.com")
                .password(passwordEncoder.encode("123456"))
                .role(Role.ADMIN)
                .build();

        User user = User.builder()
                .email("user@gmail.com")
                .password(passwordEncoder.encode("123456"))
                .role(Role.USER)
                .build();

        userRepository.saveAll(List.of(admin, user));

        // ================= CATEGORIES =================
        Category c1 = new Category();
        c1.setName("Programming");

        Category c2 = new Category();
        c2.setName("Database");

        Category c3 = new Category();
        c3.setName("DevOps");

        Category c4 = new Category();
        c4.setName("Cyber Security");

        Category c5 = new Category();
        c5.setName("Artificial Intelligence");

        Category c6 = new Category();
        c6.setName("Networking");

        Category c7 = new Category();
        c7.setName("Cloud");

        Category c8 = new Category();
        c8.setName("Web Development");

        Category c9 = new Category();
        c9.setName("Mobile Development");

        Category c10 = new Category();
        c10.setName("Data Science");

        categoryRepository.saveAll(
                List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10)
        );

        // ================= BOOKS =================
        bookRepository.saveAll(List.of(
                createBook("Clean Code", "Robert Martin", 120, 10, "Best coding practices", c1),
                createBook("Spring Boot Guide", "John Smith", 90, 15, "Complete Spring Boot", c1),
                createBook("MySQL Mastery", "David Lee", 80, 12, "Database design", c2),
                createBook("Docker Essentials", "Anna White", 70, 20, "Containers & DevOps", c3),
                createBook("Cyber Security 101", "Mark Brown", 60, 8, "Security basics", c4),
                createBook("AI for Beginners", "Sara Connor", 150, 5, "Intro to AI", c5),
                createBook("Cisco Networking", "Tom Hardy", 110, 9, "Network fundamentals", c6),
                createBook("AWS Cloud", "Emily Clark", 130, 7, "Cloud computing", c7),
                createBook("React JS", "Michael Jordan", 95, 14, "Frontend development", c8),
                createBook("Flutter Mobile", "James Bond", 85, 11, "Mobile apps", c9)
        ));

        System.out.println("Database Initialized Successfully!");
    }

    private Book createBook(String title, String author, double price,
                            int stock, String description, Category category) {

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        book.setStock(stock);
        book.setDescription(description);
        book.setCategory(category);

        return book;
    }
}