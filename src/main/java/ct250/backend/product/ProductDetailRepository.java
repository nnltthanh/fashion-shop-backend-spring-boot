package ct250.backend.product;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    ArrayList<ProductDetail> findByProduct_Id(Long productId);
    Optional<ProductDetail> findByColor(String color);
    Optional<ProductDetail> findBySize(String size);
    Optional<ProductDetail> findByColorAndSize(String color, String size);
}
