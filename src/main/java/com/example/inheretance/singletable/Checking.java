package com.example.inheretance.singletable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
@Setter
@Getter
@NoArgsConstructor
// @DiscriminatorValue(value = "1") // this string 1 it will convert to int cause we specify that in parent class (DiscriminatorColumn(discriminatorType))
public class Checking extends Account {
    private double checkLimit;
    public Checking(double balance, double checkLimit) {
        super(balance);
        this.checkLimit = checkLimit;
    }

    
}
