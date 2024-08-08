package com.example.complexmapping.compositfk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "emp_id1", referencedColumnName = "id1"),
            @JoinColumn(name = "emp_id2", referencedColumnName = "id2")
    })
    private CompanyEmployee employee;

}
