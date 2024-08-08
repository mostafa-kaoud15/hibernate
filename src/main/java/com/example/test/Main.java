package com.example.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        em.getTransaction().commit();
    }
    
}
