package ct250.backend.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @SuppressWarnings("null")
    void addProduct(Product product) {
        this.productRepository.save(product);
    }

    ArrayList<Product> getAllProducts() {
        return (ArrayList<Product>) this.productRepository.findAll();
    }

    @SuppressWarnings("null")
    public Product findProductById(Long id) {
        return  this.productRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    public void addProductDetail(Long productId, ProductDetail productDetail) {
        Product product = this.findProductById(productId);

        if (product != null) {
            productDetail.setProduct(product);
            this.productDetailRepository.save(productDetail);
        }
    }

    @SuppressWarnings("null")
    public ProductDetail updateProductDetail(ProductDetail productDetail) {
        return this.productDetailRepository.save(productDetail);
    }

    ArrayList<ProductDetail> getAllProductDetails(Long productId) {
        return (ArrayList<ProductDetail>) this.productDetailRepository.findByProduct_Id(productId);
    }

    @SuppressWarnings("null")
    public ProductDetail findProductDetailById(Long id) {
        return this.productDetailRepository.findById(id).orElse(null);
    }

    public ProductDetail findProductDetailByColor(String color) {
        return  this.productDetailRepository.findByColor(color).isPresent() ?
                this.productDetailRepository.findByColor(color).get() : null;
    }

    public ProductDetail findProductDetailBySize(String size) {
        return  this.productDetailRepository.findBySize(size).isPresent() ?
                this.productDetailRepository.findBySize(size).get() : null;
    }

    public ProductDetail findProductDetailByColorAndSize(String color, String size) {
        return  this.productDetailRepository.findByColorAndSize(color, size).isPresent() ?
                this.productDetailRepository.findByColorAndSize(color, size).get() : null;
    }

    @SuppressWarnings("null")
    void deleteProductDetailById(Long id) {
        this.productDetailRepository.deleteById(id);
    }
}
