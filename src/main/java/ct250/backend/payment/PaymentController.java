package ct250.backend.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping({ "/", "" })
    public String getAllPayment() {
        paymentService.findAllPayments();
        String paymentList = "";
        for (Payment payment : paymentService.getPayments()) {
            paymentList += "\n" + payment.toString();
        }
        return "Call find all payments function " + paymentList;
    }

    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.findPaymentById(id);
        if (payment == null) {
            return "Call find payment by ID " + id + " function\nCan not found payment with id " + id;
        }
        return "Call find payment by ID " + id + " function\n" + payment.toString();
    }

    @DeleteMapping("/{id}")
    public String deletePaymentById(@PathVariable Long id) {
        if (paymentService.deletePayment(id)) {
            return "Call delete payment by ID " + id + " function\nPayment with id " + id + " has been deleted!";
        } else if (paymentService.findPaymentById(id) == null) {
            return "Call delete payment by ID " + id + " function\nCan not found payment with id " + id;
        }

        return "Call delete payment by ID " + id + " function\n" + "Can not delete payment has id " + id;

    }

    @PutMapping("/{id}")
    public String updatePaymentById(@PathVariable Long id, @RequestBody Payment payment) {
        if (paymentService.updatePayment(id, payment) != null) {
            return "Call update payment by ID " + id + " function\n"
                    + paymentService.updatePayment(id, payment).toString();
        }
        return "Call update payment by ID " + id + " function\n" + "Failed Update!!!Not found Payment";
    }

    @PostMapping("/add")
    public String addPayment(@RequestBody Payment payment) {
        payment = paymentService.addPayment(payment);
        if (payment == null) {
            return "Call add payment function \n" + "Add payment failed";
        }
        return "Call add payment function \n" + payment.toString();
    }
}
