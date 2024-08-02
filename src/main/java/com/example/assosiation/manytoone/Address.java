package com.example.assosiation.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Address {
    @Id
    @Column(name = "address_id")
    private int id;
    private int streetNum;
    private int code;
    @ManyToOne()
   /*  @JoinTable(name = "person_addresses", joinColumns = { @JoinColumn(name = "address_id") }, inverseJoinColumns = {
            @JoinColumn(name = "person_id") }) */
    private Person person;

}
