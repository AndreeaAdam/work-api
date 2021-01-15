package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long stock;

    @OneToMany(mappedBy = "product")
    private List<ListOfPurchases> listOfPurchases;
}
