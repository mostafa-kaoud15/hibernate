package com.example.inheretance.jointables;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int var1;
    

    public Account(int var1) {
        this.var1 = var1;
    }
}
