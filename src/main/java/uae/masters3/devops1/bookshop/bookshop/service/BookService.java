package uae.masters3.devops1.bookshop.bookshop.service;


import org.springframework.data.domain.Page;
import uae.masters3.devops.bookshop.api.dto.BookResponse;

public interface BookService {
    // La pagination est obligatoire selon le barème (Pageable)
    Page<BookResponse> getAllBooks(int page, int size);
    BookResponse getBookById(Long id);
}
