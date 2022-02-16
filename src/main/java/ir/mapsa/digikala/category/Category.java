package ir.mapsa.digikala.category;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;



}
