package com.example.hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "city")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    @EqualsAndHashCode.Include
    private String firstName;
    @Column(name = "last_name")
    @EqualsAndHashCode.Include
    private String lastName;
    @EqualsAndHashCode.Include
    private String gender;
    @EqualsAndHashCode.Include
    private int age;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

}

