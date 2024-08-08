package com.example.complexmapping.secondarytable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student std = new Student("Mostafa Kaoud", 21, Gender.mail, 3, 3.45f);
        em.persist(std);
        em.getTransaction().commit();
        
    }

}
