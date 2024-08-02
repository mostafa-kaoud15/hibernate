package com.example.assosiation.embedded;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Car {
    private String model;
    private int speed;
    private String color;
    
}
