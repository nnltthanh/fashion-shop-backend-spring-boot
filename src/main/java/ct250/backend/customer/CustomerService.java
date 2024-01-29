package ct250.backend.customer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    void addCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    ArrayList<Customer> getAllCustomers() {
        return (ArrayList<Customer>) this.customerRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        return  this.customerRepository.findById(id).isPresent() ? 
                this.customerRepository.findById(id).get() : null;
    }

}
