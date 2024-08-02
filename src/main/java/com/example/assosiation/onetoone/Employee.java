package com.example.assosiation.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "oneToOneEmployee")
@Table(name = "myEmployee")
@Setter
@Getter
public class Employee {
    @Id
    private int id;
    private String fName;
    private String lName;
    @OneToOne(mappedBy = "employee")
    @PrimaryKeyJoinColumn
    private Device device;
}
