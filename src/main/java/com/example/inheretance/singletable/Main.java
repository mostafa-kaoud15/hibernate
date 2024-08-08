package com.example.inheretance.singletable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account saving = new Saving(838000, 3500);
        em.persist(saving);
        em.getTransaction().commit();
    }
    
}
