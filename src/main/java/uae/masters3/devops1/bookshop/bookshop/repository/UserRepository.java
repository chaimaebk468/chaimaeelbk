package uae.masters3.devops1.bookshop.bookshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uae.masters3.devops1.bookshop.bookshop.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}