package com.example.assosiation.cascade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    

    public Bus() {}
    
    public Bus(String model) {
        this.model = model;
    }

    public Bus(long id, String model) {
        this.id = id;
        this.model = model;
    }

}
