package ct250.backend.coupon;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@Table(name = "coupon")
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String code;

    @Column
    private String description;

    @Column(length = 50)
    private String type;

    @Column
    private double value;

    @Column(name = "start_date")
    @Temporal(value = TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(value = TemporalType.DATE)
    private Date endDate;

    @Column(name = "min_spend")
    private double minSpend;

    @Column(name = "capped_at")
    private double cappedAt;

    @Column(name = "uses_per_coupon")
    private int usesPerCoupon;

    @Column(length = 20)
    private String status;

    @Column(name = "created_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedAt;
}
