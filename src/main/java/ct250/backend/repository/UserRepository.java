package ct250.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ct250.backend.model.User;

@Repository
public
interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);
}
