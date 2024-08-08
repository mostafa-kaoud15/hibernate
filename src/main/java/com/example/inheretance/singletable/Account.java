package com.example.inheretance.singletable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
@Setter
@Getter
@NoArgsConstructor
/* @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Account_type", discriminatorType = DiscriminatorType.INTEGER)
 */public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    } 

}
