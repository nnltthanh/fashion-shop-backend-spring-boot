package ct250.backend.admin;

import ct250.backend.employee.Employee;
import ct250.backend.warehouse.Warehouse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "manager")
public class Manager extends Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "employee_id", referencedColumnName = "id")
//    private Employee employee;

    @OneToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

//    @Column
//    private String nickname;
}