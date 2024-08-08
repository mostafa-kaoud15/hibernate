package com.example.complexmapping.compositpk;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
public class Ids {

    private int id1;
    private int id2;

    public Ids(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
    
}
