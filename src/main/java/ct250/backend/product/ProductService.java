package ct250.backend.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public ArrayList<Product> findProductByTypes(ArrayList<ProductType> types) {
        ArrayList<Product> filteredProducts = new ArrayList<Product>();
        for (ProductType type : types) {
            filteredProducts.addAll(this.productRepository.findProductsByType(type));
        }
        return filteredProducts;
    }
    public ArrayList<ProductDetail> findProductDetailByColor(String color) {
        return (ArrayList<ProductDetail>) this.productDetailRepository.findByColor(color);
    }

    public ArrayList<ProductDetail> findProductDetailByColor(Long productId, String color) {
        Product product = this.findProductById(productId);
        return (ArrayList<ProductDetail>) this.productDetailRepository.findByColor(color);
    }

    public ArrayList<ProductDetail> findProductDetailBySize(String size) {
        return (ArrayList<ProductDetail>) this.productDetailRepository.findBySize(size);
    }

    public ArrayList<ProductDetail> findProductDetailByColorAndSize(String color, String size) {
        return (ArrayList<ProductDetail>) this.productDetailRepository.findByColorAndSize(color, size);
    }

    @SuppressWarnings("null")
    void deleteProductDetailById(Long id) {
        this.productDetailRepository.deleteById(id);
    }
}
