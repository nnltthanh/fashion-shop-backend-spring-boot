package ct250.backend.cart;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ct250.backend.customer.CustomerService;
import ct250.backend.product.ProductDetail;
import ct250.backend.product.ProductService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    public CartDetail addProductDetailToCart(Long customerId, Long productDetailId, CartDetail cartDetail) {
        Cart cart = this.findCartByCustomerId(customerId);
    
        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(this.customerService.findCustomerById(customerId));
        }
    
        ProductDetail productDetail = this.productService
                                .findProductDetailById(productDetailId);
    
        int remainingQuantity = productDetail.getQuantity() - cartDetail.getQuantity();
    
        if (remainingQuantity >= 0) {
            productDetail.setQuantity(remainingQuantity);
            this.productService.addProductDetail(productDetail.getProduct().getId(), productDetail);
    
            BigDecimal total = BigDecimal.valueOf(cartDetail.getQuantity())
                                .multiply(productDetail.getProduct().getPrice());
            
            cartDetail.setProductDetail(productDetail);
            cartDetail.setQuantity(cartDetail.getQuantity());
            cartDetail.setTotal(total);
    
            cart.addCartDetail(cartDetail);
    
            this.cartRepository.save(cart);
    
            return this.cartDetailRepository.save(cartDetail);
        }

        return null;
    }
    
    ArrayList<CartDetail> getAllCartDetails(Long customerId) {
        Cart cart = this.findCartByCustomerId(customerId);
        return new ArrayList<>(cart.getCartDetails());
    }

    private Cart findCartByCustomerId(Long customerId) {
        return  this.cartRepository.findByCustomer_Id(customerId).isPresent() ?
                this.cartRepository.findByCustomer_Id(customerId).get() : null;
    }

    public CartDetail findCartDetailById(Long id) {
        return  this.cartDetailRepository.findById(id).isPresent() ?
                this.cartDetailRepository.findById(id).get() : null;
    }

    public void deleteCartDetail(Long id) {
        this.cartDetailRepository.deleteById(id);
    }
    
}
