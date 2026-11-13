
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book extends Element {

    private String title;
    private String author;

    // LAB 5-6 - Relatie ManyToMany intre Book si Author
    @ManyToMany
    private List<Author> authors = new ArrayList<>();

    // Continutul cartii este pastrat doar in memorie
    @Transient
    private List<Element> contents = new ArrayList<>();

    // Constructor necesar pentru JPA
    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(Long id, String title, String author) {
        setId(id);
        this.title = title;
        this.author = author;
    }

    // getId() si setId() sunt mostenite din Element

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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    // LAB 5-6 - Nu serializam continutul temporar in JSON
    @JsonIgnore
    public List<Element> getContents() {
        return contents;
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

    // LAB 3 - Visitor
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for (Element element : contents) {
            element.accept(visitor);
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
