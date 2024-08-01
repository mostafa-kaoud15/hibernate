package com.example.persistence.domains;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myEmployees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fullName")
    @Access(AccessType.PROPERTY)
    private String name;
    private float salary;

    public Employee(int id, String name, float salary ) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {}

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getSalary() {
        return salary;
    }
    public void setName(String name) {
        //System.out.println("setName");
        this.name = name;
    }
    public void setSalary(float salary) {
       // System.out.println("setSalary");
        this.salary = salary;
    }
    public void setId(long id) {
        // System.out.println("setId");
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("id: %d name: %s salary: %f", id, name, salary);
    }
    
}
