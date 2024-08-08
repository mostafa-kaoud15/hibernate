package com.example.complexmapping.secondarytable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@SecondaryTable(name = "people")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(table="people")
    private String name;
    @Column(table="people")
    private int age;
    @Column(table="people")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int whichGrad;
    private float gpa;

    public Student(String name, int age, Gender gender, int whichGrad, float gpa) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.gpa = gpa;
        this.whichGrad = whichGrad;
    }


}
