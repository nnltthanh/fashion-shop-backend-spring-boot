package ct250.backend.review;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import ct250.backend.customer.Customer;
import ct250.backend.order.OrderDetail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String content;

    @CreatedDate
    private Date createDate;
    
    private float rate;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

}
