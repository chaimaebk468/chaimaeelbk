package uae.masters3.devops1.bookshop.bookshop.service.Impl; // Package corrigé selon la norme obligatoire

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uae.masters3.devops1.bookshop.bookshop.dto.BookResponse;
import uae.masters3.devops1.bookshop.bookshop.entity.Book;
import uae.masters3.devops1.bookshop.bookshop.repository.BookRepository;
import uae.masters3.devops1.bookshop.bookshop.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    // L'injection par constructeur est la meilleure pratique
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<BookResponse> getAllBooks(int page, int size) {
        // Respect de la contrainte de pagination (Membre 3)
        return bookRepository.findAll(PageRequest.of(page, size))
                .map(this::mapToResponse);
    }

    @Override
    public BookResponse getBookById(Long id) {
        // Utilisation d'une exception (tu pourras créer ResourceNotFoundException plus tard)
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livre introuvable avec l'ID : " + id));
        return mapToResponse(book);
    }

    private BookResponse mapToResponse(Book book) {
        // Assure-toi que ton DTO BookResponse a un constructeur qui accepte ces paramètres
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getStock(),
                book.getDescription(),
                book.getCategory() != null ? book.getCategory().getName() : "Sans catégorie"
        );
    }
}