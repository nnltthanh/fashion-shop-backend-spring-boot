package ct250.backend.order;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ct250.backend.cart.CartService;
import ct250.backend.customer.Customer;
import ct250.backend.customer.CustomerService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    void addOrder(Long customerId, Order order) {
        Customer customer = this.customerService.findById(customerId);
        order.setStatus(order.getStatus());
        order.setCustomer(customer);

        this.orderRepository.save(order);
    }

    ArrayList<Order> findAllOrders(Long customerId) {
        return (ArrayList<Order>) this.orderRepository.findByCustomer_Id(customerId);
    }

    @SuppressWarnings("null")
    Order findOrderById(Long id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    void cancelOrder(Long orderId) {
        this.orderRepository.deleteById(orderId);
    }

    ArrayList<OrderDetail> addOrderDetailsToOrder(Long orderId, Long[] cartDetailsIdList) {

        Arrays.stream(cartDetailsIdList).forEach(id -> {
            OrderDetail orderDetail = new OrderDetail(this.cartService.findCartDetailById(id));
            orderDetail.setOrder(this.findOrderById(orderId));
            this.cartService.deleteCartDetail(id);
            this.orderDetailRepository.save(orderDetail);
        });

        return this.findAllOrderDetailsByOrder(orderId);
    }

    ArrayList<OrderDetail> findAllOrderDetailsByOrder(Long orderId) {
        return (ArrayList<OrderDetail>) this.orderDetailRepository.findByOrder_Id(orderId);
    }

    @SuppressWarnings("null")
    public OrderDetail findOrderDetailById(Long id) {
        return this.orderDetailRepository.findById(id).orElse(null);
    }

}