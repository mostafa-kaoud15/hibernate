package com.example.assosiation.embedded;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Customer {
    @Id
    private Long id;
    private String name;
    private int age;
    @Embedded
    private Car car;
    
}
