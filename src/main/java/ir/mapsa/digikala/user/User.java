package ir.mapsa.digikala.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String family;

    @Column
    private String phone;

//    @OneToMany
//    private List<Product> products;

}
