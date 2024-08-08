package com.example.inheretance.jointables;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
@Setter
@Getter
@NoArgsConstructor
public class Saving extends Account{

    private int var3;

    public Saving (int var1, int var3) {
        super(var1);
        this.var3 = var3;
    }
    
}
