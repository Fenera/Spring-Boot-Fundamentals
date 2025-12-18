package com.application.store.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.beans.ConstructorProperties;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "email")
    private String email;
    @Column(nullable = false, name = "password")
    private String password;

    // A user can have many addresses
    @OneToMany(mappedBy = "user") // user is the name of the field in Address
    @Builder.Default // include this initialization
    private List<Address> addresses = new ArrayList<>();


    // use JoinTable in owner class for many-to-many relationship
    @ManyToMany
    @JoinTable(name = "user_tags",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @Builder.Default // builder design pattern ignores this initialization at runtime
    private Set<Tag> tags = new HashSet<>();


    @OneToOne(mappedBy = "user") // user is the user object in the Profile class
    private Profile profile;

    public void addAddress(Address address){
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address){
        addresses.remove(address);
        address.setUser(null);
    }

    public void addTag(String tagName){
        var tag = new Tag(tagName);
        tags.add(tag);
        tag.getUsers().add(this);
    }
    public void removeTag(Tag tag){
        tags.remove(tag);
        tag.setUsers(null);
    }

    public void addProfile(Profile profile){
        this.profile = profile;
        profile.setUser(this);
    }
}
