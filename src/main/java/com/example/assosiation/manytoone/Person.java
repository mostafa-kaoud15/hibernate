package com.example.assosiation.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/* @Setter
@Getter
@Entity */
public class Person {
    // @Id
    private int id;
    private String firstName;
    private String lastName;
    
    /* @OneToMany(mappedBy = "person")
    private List<Address> addresses; */
  
}
