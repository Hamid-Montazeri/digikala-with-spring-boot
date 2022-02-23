package ir.mapsa.digikala.product.entity;

import ir.mapsa.digikala.cart.entity.Cart;
import ir.mapsa.digikala.category.entity.Category;
import ir.mapsa.digikala.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double regularPrice;

    @Column
    private Double salePrice;

    @Column
    private String image;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;


}
