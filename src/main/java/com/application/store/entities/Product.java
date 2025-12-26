package com.application.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products", schema = "store")
public class Product {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT",
    nullable = false)
    private String description;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToMany
    private Set<User> users;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

}