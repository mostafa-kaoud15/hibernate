package com.example.inheretance.concretetable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // it have to be sequence or table
    private Long id;
    private int var1;
    

    public Account(int var1) {
        this.var1 = var1;
    }
}
