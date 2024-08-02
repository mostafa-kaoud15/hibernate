package com.example.assosiation.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Device {
    @Id
    private Long id;
    private String model;
    private int ability;

    @OneToOne
    @JoinColumn(name="employee_id")
    @PrimaryKeyJoinColumn
    private Employee employee;
    
}
