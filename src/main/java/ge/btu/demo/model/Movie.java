package ge.btu.demo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true)
    private String title;
    @Column(nullable = false)
    private String country;

}
