package com.application.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @ToString.Exclude
    private Set<User> users = new HashSet<>();

    public Tag(String name){
        this.name = name;
    }
}

