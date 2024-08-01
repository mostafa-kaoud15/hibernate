package com.example;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.persistence.domains.Employee;

public class Main {
    static Logger logger = Logger.getLogger(Employee.class.getName());
    static {
        try {
            FileHandler fileHandler = new FileHandler("translogsaction.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "failing while set FileHandeler and FileFormatter : " + ex);
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            // persist
            /*
             * Employee emp = new Employee("mostafa kaoud", 30000);
             * em.persist(emp);
             * emp.setName("Nader Ali");
             */

            // find(class, idL)
            /*
              // if the entity doesn't exist in the context it will be query to database to get the object(to context and return it)
              Employee emp = em.find(Employee.class, 7L); // it return the object to context and return it
              System.out.println(emp);
              emp = em.find(Employee.class, 1L); // return null
              System.out.println(emp);
             */

            // getReference(class, idL)
            /*
             * // query for the db when it is needed and save the proxy in the context
             * Employee emp = em.getReference(Employee.class, 6L);
             * System.out.println(emp);
             */

            // detach(object)
            /*
             * // emp1 reference to object in the context
             * Employee emp1 = em.find(Employee.class, 1L);
             * // after detach move the object from the context to outside
             * // emp1 after detach refrence to the object outside the context instead of
             * the inside context
             * em.detach(emp1);
             * // update the detached object is not affect the db object
             * emp1.setSalary(250000);
             */

            // merge()
            /*
             * detach(object)
             * // emp1 reference to object in the context
             * Employee emp1 = em.find(Employee.class, 1L);
             * // after detach move the object from the context to outside
             * // emp1 after detach refrence to the object outside the context instead of
             * the inside context
             * em.detach(emp1);
             * // update the detached object
             * emp1.setSalary(250000);
             * 
             * // copy the changed state of the outside object(emp1) to context object(emp2)
             * // it is not move the object to persistence layer(context)(only copy the
             * changed state)
             * // so any change to the object outside the persistence layer after merging
             * not affect the object in database
             * Employee emp2 = em.find(Employee.class, 1L);
             * em.merge(emp1);
             * 
             * // merge -> it return the context object after the copy state
             * // so if i assign the merge to the outside object it will be referece to the
             * context object after assign the different state
             * emp1.setName("Ahmed Aly");
             * emp1 = em.merge(emp1);
             * emp1.setSalary(500000);
             * 
             * 
             * importante -> if there are no object in context hase id the same of the
             * detached object it will reload the object to context from the database to the
             * context before the merge
             */

            // merge for insert -> id must have a default value in the db
            /*
             * Employee emp = new Employee("khaled ali", 800000);
             * Employee emp2 = new Employee(101, "Waheed kaoud", 100000000); // it will
             * insert it with the db increament not this id "101"
             * emp = em.merge(emp);
             * em.merge(emp2);
             * System.out.println("\n" + emp.getId() + "\t" + emp.getName() + '\t'+
             * emp.getSalary());
             */

            // merge for update (use the id which is exactuly existed in the database or in
            // the context)
            /*
             * // this will update(name and salary) of the id 5 cause the 5 is exist but if
             * it is not it will be inserted
             * em.merge(new Employee(5, "fawzia ali", 3444445));
             */

            // remove
            // * remove transit object
            // 1 - id auto-increament -> it will do nothing
            // 2 - user enter id -> it will select the object to the context and do nothing
            /*
             * Book b = new Book(2, "cracking the code interview");
             * em.remove(b);
             * // * detached object
             */

            // * remove detach object -> can't remove the detach object
            /*
             * Employee emp = new Employee("khaled Nawagie", 24000);
             * em.persist(emp);
             * em.detach(emp);
             * em.remove(emp);
             */

            // remove the managed object -> it will remove it (you have managed it before remove it)
            /*
             * Employee emp = em.find(Employee.class, 2L);
             * em.remove(emp);
             */

            Employee emp = new Employee("khaled ", 2000000);
            System.out.println("1 -------------------------");
            em.persist(emp);
            System.out.println("2 -------------------------");
            em.detach(emp);
            System.out.println("3 -------------------------");
            Employee Empp = new Employee(3, "Ahmed Ali", 4000000);
            System.out.println("4 -------------------------");
            em.merge(Empp);
            System.out.println("5 -------------------------");
            transaction.commit();
            System.out.println("6 -------------------------");


        } catch (Exception e) {
            transaction.rollback();
            logger.log(Level.SEVERE, "error while the insert the employee -> " + e);

        } finally {
            em.close();
            emf.close();
            logger.info("Enity manager factory and Entity Manager hase been cloesd successfully");
        }

    }
}