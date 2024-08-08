package com.example.inheretance.jointables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account checking = new Checking(100, 300);
        em.persist(checking);
        em.getTransaction().commit();
    }

}
