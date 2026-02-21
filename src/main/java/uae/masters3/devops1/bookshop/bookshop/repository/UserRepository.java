package uae.masters3.devops.bookshop.api.repository;

import uae.masters3.devops.bookshop.api.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}