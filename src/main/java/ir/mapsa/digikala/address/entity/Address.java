package ir.mapsa.digikala.address.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    private String city;

    private String mainStreet;

    private String alley;

    private Integer numberPlate;

    private Integer apartmentNumber;

    private String postalCode;

    private Long latitude;

    private Long longitude;





}
