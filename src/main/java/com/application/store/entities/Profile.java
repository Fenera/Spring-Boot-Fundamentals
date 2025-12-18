package com.application.store.entities;


import jakarta.persistence.*;
import lombok.*;

@ToString
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    private Long id;

    @Column(name = "bio")
    private String bio;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "loyalty_points")
    private Integer loyalty_points;

    @OneToOne
    @JoinColumn(name = "id") // profile knows about user but user doesn't know about profile (so owner)
    @MapsId // use id as both pk and fk
    @ToString.Exclude
    private User user;

}
