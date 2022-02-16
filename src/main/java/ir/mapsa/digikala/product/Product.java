package ir.mapsa.digikala.product;

import ir.mapsa.digikala.category.Category;
import ir.mapsa.digikala.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
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



}
