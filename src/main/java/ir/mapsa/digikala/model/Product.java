package ir.mapsa.digikala.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "regular_price", nullable = false)
    private Double regularPrice;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column
    private String image;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Category category;

/*    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;*/


}
