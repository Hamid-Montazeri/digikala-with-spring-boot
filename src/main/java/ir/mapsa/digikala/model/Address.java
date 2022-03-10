package ir.mapsa.digikala.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    private String city;

    @Column(name = "main_street")
    private String mainStreet;

    private String alley;

    @Column(name = "number_plate")
    private Integer numberPlate;

    @Column(name = "apartment_number")
    private Integer apartmentNumber;

    @Column(name = "postal_code")
    private String postalCode;

    private Long latitude;

    private Long longitude;





}
