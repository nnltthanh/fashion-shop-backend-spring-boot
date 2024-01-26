package ct250.backend.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.ArrayList;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    private ArrayList<Payment> payments;

    public PaymentService(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public PaymentService() {
        this.payments = new ArrayList<>();
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public ArrayList<Payment> findAllPayments() {
        System.out.println("Call find all payments function");
        this.payments = (ArrayList<Payment>) paymentRepository.findAll();
        for (Payment a : payments) {
            System.out.println(a.toString());
        }
        return payments;
    }

    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Transactional
    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = findPaymentById(id);
        if (existingPayment != null) {
            // Update fields based on your requirements
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setStatus(payment.getStatus());
            // existingPayment.setDate(payment.getDate());
            existingPayment.setMethod(payment.getMethod());

            paymentRepository.save(existingPayment);
            return existingPayment;
        }
        return null;
    }

    @Transactional
    public boolean deletePayment(Long id) {
        Payment resultFindPayment = findPaymentById(id);
        if (resultFindPayment != null) {
            paymentRepository.delete(resultFindPayment);
            return true;
        } else {
            return false;
        }
    }
}
