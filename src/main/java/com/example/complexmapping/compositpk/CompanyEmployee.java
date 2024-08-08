package com.example.complexmapping.compositpk;

import javax.persistence.EmbeddedId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
@Setter
@Getter
@NoArgsConstructor
public class CompanyEmployee {
    @EmbeddedId
    private Ids ids;
    private String name;
    private int age;

    public CompanyEmployee(Ids ids, String name, int age) {
        this.ids = ids;
        this.name = name;
        this.age = age;
    }

    
    
}
