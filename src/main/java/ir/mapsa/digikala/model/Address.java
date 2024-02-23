package ir.mapsa.digikala.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_address")
public class Address {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // no need, because of using @MapsId
    private Long id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String mainStreet;

    @Column(nullable = false)
    private String alley;

    @Column(nullable = false)
    private Integer numberPlate;

    @Column(nullable = false)
    private Integer apartmentNumber;

    @Column(nullable = false)
    private String postalCode;

    @Column
    private Long latitude;

    @Column
    private Long longitude;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
