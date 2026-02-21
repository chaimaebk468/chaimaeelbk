package uae.masters3.devops1.bookshop.bookshop.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uae.masters3.devops1.bookshop.bookshop.entity.Category;
<<<<<<< HEAD

=======
>>>>>>> 08ea5e05ef593f75f8041a09709163fe2a750443

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Cette interface permet de gérer toutes les opérations CRUD pour les catégories [cite: 462]
}