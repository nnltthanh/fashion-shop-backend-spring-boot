package ct250.backend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping(value = {"/", ""})
    public ArrayList<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = this.productService.findProductById(id);
        if (product == null) {
            return new ResponseEntity<>("This product is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        Product product = this.productService.findProductById(id);
        if (product == null) {
            return new ResponseEntity<>("Can not find product to delete", HttpStatus.NOT_FOUND);
        }
        
        this.productService.deleteProductById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/filtered/type")
    public ResponseEntity<?> getAllFilteredProductsByTypes(@RequestParam ArrayList<ProductType> productTypes) {
        if (productTypes == null || productTypes.isEmpty()) {
            return new ResponseEntity<>("Product types parameter is required", HttpStatus.BAD_REQUEST);
        }
        ArrayList<Product> filteredProducts = this.productService.findProductByTypes(productTypes);
        if (filteredProducts.size() < 1) {
            return new ResponseEntity<>("Cannot find any product in types: { " + productTypes + " }", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{productId}/details")
    public ArrayList<ProductDetail> getAllProductDetails(@PathVariable Long productId) {
        return this.productService.getAllProductDetails(productId); 
    }

    @GetMapping(value = "/{productId}/details/{id}")
    public ResponseEntity<?> getProductDetailById(@PathVariable Long id) {
        ProductDetail productDetail = this.productService.findProductDetailById(id);
        if (productDetail == null) {
            return new ResponseEntity<>("This product detail is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDetail, HttpStatus.OK);
    }

    @PostMapping(value = "/{productId}/details")
    public ResponseEntity<ProductDetail> addProductDetail(@PathVariable Long productId, @RequestBody ProductDetail productDetail) {
        this.productService.addProductDetail(productId, productDetail);
        return new ResponseEntity<>(productDetail, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}/details/{id}")
    public ResponseEntity<String> deleteProductDetailById(@PathVariable Long id) {
        ProductDetail productDetail = this.productService.findProductDetailById(id);
        if (productDetail == null) {
            return new ResponseEntity<>("Can not find product detail to delete", HttpStatus.NOT_FOUND);
        }
        
        this.productService.deleteProductDetailById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
