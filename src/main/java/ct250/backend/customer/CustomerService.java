package ct250.backend.customer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ArrayList<Customer> findAll() {
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    @SuppressWarnings("null")
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer findByAccount(String account) {
        return customerRepository.findByAccount(account).orElse(null);
    }

    @SuppressWarnings("null")
    public void add(Customer customer) {
        this.customerRepository.save(customer);
    }

    @SuppressWarnings("null")
    public void deleteById(Long id) {
        this.customerRepository.deleteById(id);
    }
}
