package com.example.persistence.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private Long id;
    private String title;

    public Book() {
        System.out.println("book default constructor");
    }
    public Book(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
