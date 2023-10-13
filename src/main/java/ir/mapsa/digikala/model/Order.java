package ir.mapsa.digikala.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Temporal(value = TemporalType.DATE)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


}
