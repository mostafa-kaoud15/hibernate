package com.example.assosiation.cascade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.ALL})
    @JoinColumn(name = "driver_id")
    List<Bus> buses;
    

    public Driver() {}

    public Driver(String name) {
        this.name = name;
    }
    public Driver(long id, String name) {
        this.name = name;
        this.id = id;
    }
 
    
}
