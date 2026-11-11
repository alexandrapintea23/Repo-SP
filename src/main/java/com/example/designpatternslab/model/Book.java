
package com.example.designpatternslab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @Transient
    private List<Author> authors = new ArrayList<>();

    @Transient
    private List<Element> contents = new ArrayList<>();

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

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

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        add(element);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);

        for (Author a : authors) {
            a.print();
        }

        for (Element element : contents) {
            element.print();
        }
    }

    @Override
    public void add(Element element) {

        if (element == null) {
            throw new IllegalArgumentException(
                    "Nu poti adauga un element null."
            );
        }

        if (element.getParent() != null) {
            throw new IllegalStateException(
                    "Elementul apartine deja unei sectiuni sau carti!"
            );
        }

        if (element == this) {
            throw new IllegalArgumentException(
                    "O carte nu se poate contine pe ea insasi!"
            );
        }

        // Evitam ciclurile intre elemente
        Element current = this;

        while (current != null) {
            if (current == element) {
                throw new IllegalArgumentException(
                        "Nu poti crea un ciclu intre elemente!"
                );
            }

            current = current.getParent();
        }

        contents.add(element);
        element.setParent(this);
    }

    @Override
    public void remove(Element element) {
        if (contents.remove(element)) {
            element.setParent(null);
        }
    }

    @Override
    public Element get(int index) {
        return contents.get(index);
    }
}
