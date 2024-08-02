package com.example.assosiation.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="person")
public class Person {
    @Id
    private Long id;
    private String name;
    private int age;
    @ManyToMany
    @JoinTable(name = "person_car", joinColumns = {@JoinColumn(name = "person_id")}, inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private List<Car> cars;
    
}
