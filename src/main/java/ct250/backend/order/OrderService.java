package ct250.backend.order;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository OrderRepository;

    void addOrder(Order order) {
        this.OrderRepository.save(order);
    }

    ArrayList<Order> getAllOrders() {
        return (ArrayList<Order>) this.OrderRepository.findAll();
    }
}