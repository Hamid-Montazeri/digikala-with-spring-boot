package ir.mapsa.digikala.cart.entity;

import ir.mapsa.digikala.user.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

}
