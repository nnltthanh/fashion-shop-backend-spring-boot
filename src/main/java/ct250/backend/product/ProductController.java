package ct250.backend.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping(value = {"/", ""})
    public ArrayList<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

}
