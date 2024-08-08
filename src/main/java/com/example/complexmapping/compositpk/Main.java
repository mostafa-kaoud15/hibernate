package com.example.complexmapping.compositpk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Ids ids = new Ids();
        CompanyEmployee emp = new CompanyEmployee(ids, "Mostafa Kaoud", 31);
        em.persist(emp);
        em.getTransaction().commit();
        
    }

}
