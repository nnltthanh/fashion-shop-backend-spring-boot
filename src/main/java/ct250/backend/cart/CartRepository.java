package ct250.backend.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CartRepository extends JpaRepository<Cart, Long> {
    
}
