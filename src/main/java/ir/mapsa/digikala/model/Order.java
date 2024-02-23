package ir.mapsa.digikala.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
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
