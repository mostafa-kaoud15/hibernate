package com.example.assosiation.cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // merge
        /* 
        Bus b = new Bus(2, "Merch");
        Driver driver = new Driver(1, "Mostafa");
        driver.setBus(b);
        em.merge(driver); */

        // persist
        /* Driver driver = new Driver("Nader");
        Bus bus = new Bus("TokTok");
        driver.setBus(bus);
        em.persist(driver); */

        // remove (remove the parent and its child from db when i remove the parent)
        // cant remove the child where it hase parent
       /*  Driver driver = em.find(Driver.class, 4L);
        em.remove(driver); 
        */

        em.getTransaction().commit();

    
    }
    
}
