package ir.mapsa.digikala.address.entity;

import lombok.Builder;
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

    private String mainStreet;

    private String alley;

    private Integer numberPlate;

    private Integer apartmentNumber;

    private String postalCode;

    private Long latitude;

    private Long longitude;





}
