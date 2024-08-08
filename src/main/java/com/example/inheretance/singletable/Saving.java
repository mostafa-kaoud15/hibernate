package com.example.inheretance.singletable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
@Setter
@Getter
@NoArgsConstructor
// @DiscriminatorValue(value = "2")
public class Saving extends Account{
    private double interest;

    public Saving(double balance, double interest) {
        super(balance);
        this.interest = interest;
    }
    
}