package ct250.backend.order;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import ct250.backend.coupon.Coupon;
import ct250.backend.customer.Customer;
import ct250.backend.payment.Payment;
import ct250.backend.shipment.Shipment;
import ct250.backend.staff.Staff;
import ct250.backend.warehouse.Warehouse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@Table(name = "customer_order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date createDate; 

    private long total;
    
    private int status;

    @OneToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @OneToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
