package ct250.backend.customer;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String account;

    @Column(length = 30)
    private String password;

    @Column(length = 50)
    private String name;

    @Column
    private String address;

    @Column(length = 12)
    private String phone;

    @Column(length = 80)
    private String email;

    @Column(name = "avatar_url")
    private String avatar;

    @Temporal(value = TemporalType.DATE)
    private Date dob;

    @Column(name = "created_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedAt;
}
