package com.example.assosiation.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Car {
    @Id
    private Long id;
    private String model;
    private String color;
    private float salary;
    @ManyToMany(mappedBy = "cars")
    private List<Person> tenants;
    
}
