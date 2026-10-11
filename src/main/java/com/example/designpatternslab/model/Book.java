
package com.example.designpatternslab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Book implements Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    // Constructor fara parametri, necesar pentru JPA
    public Book() {
    }

    // Constructor cu parametri
    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters si Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Metoda pentru design pattern-ul Composite
    @Override
    public void print() {
        System.out.println("Book: " + title + " by " + author);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException(
                "Cannot add elements to a Book"
        );
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException(
                "Cannot remove elements from a Book"
        );
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException(
                "Cannot get elements from a Book"
        );
    }
}
