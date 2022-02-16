package ir.mapsa.digikala.category;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

}
