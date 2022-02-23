package ir.mapsa.digikala.user.entity;

import ir.mapsa.digikala.address.entity.Address;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String family;

    @Column
    private String phone;

    @OneToOne
    private Address address;

}
