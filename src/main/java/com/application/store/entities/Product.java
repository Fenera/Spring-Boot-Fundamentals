package com.application.store.entities;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private BigDecimal price;

    public Product(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    @ManyToOne
    // product is the owner of the relationship
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private Category category;
}
