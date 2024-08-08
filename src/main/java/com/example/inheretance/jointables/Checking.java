package com.example.inheretance.jointables;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
@Setter
@Getter
@NoArgsConstructor
public class Checking extends Account {
    private int var2;
    
    public Checking(int var1, int var2) {
        super(var1);
        this.var2 = var2;
    }
    
}
