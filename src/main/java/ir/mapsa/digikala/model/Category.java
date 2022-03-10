package ir.mapsa.digikala.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}
