package uae.masters3.devops1.bookshop.bookshop.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uae.masters3.devops.bookshop.api.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Cette interface permet de gérer toutes les opérations CRUD pour les livres [cite: 462]
    // Elle sera utilisée plus tard pour implémenter la pagination demandée [cite: 483]
}
