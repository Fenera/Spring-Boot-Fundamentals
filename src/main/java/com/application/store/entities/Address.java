package com.application.store.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zip")
    private String zip;
    @Column(name = "state")
    private String state;

    // many addresses belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

}
