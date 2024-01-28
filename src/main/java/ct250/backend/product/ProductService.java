package ct250.backend.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    void addProduct(Product product) {
        this.productRepository.save(product);
    }

    ArrayList<Product> getAllProducts() {
        return (ArrayList<Product>) this.productRepository.findAll();
    }

    Product findProductById(Long id) {
        return  this.productRepository.findById(id).isPresent() ? 
                this.productRepository.findById(id).get() : null;
    }

    void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }
}
