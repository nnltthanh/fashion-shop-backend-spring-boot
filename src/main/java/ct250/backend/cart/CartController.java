package ct250.backend.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers/{customerId}/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping(value = "/{productDetailId}")
    public ResponseEntity<CartDetail> addProductDetailToCart(@PathVariable Long customerId,
            @PathVariable Long productDetailId, @RequestBody CartDetail cartDetail) {
        return new ResponseEntity<>(this.cartService.addProductDetailToCart(customerId, productDetailId, cartDetail),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<CartDetail> getCart(@PathVariable Long customerId) {
        return this.cartService.getAllCartDetails(customerId);
    }

    @GetMapping("/{cartDetailId}")
    public CartDetail getCartDetail(@PathVariable Long cartDetailId) {
        return this.cartService.findCartDetailById(cartDetailId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCartDetail(@PathVariable(value = "customerId") Long customerId, @PathVariable(value = "id") Long id) {
        System.out.println(customerId + " " + id);
        this.cartService.deleteCartDetail(id);
        return new ResponseEntity<>(this.cartService.getAllCartDetails(customerId), HttpStatus.OK);
    }

}
