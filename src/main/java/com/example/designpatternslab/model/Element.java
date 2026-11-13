
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Element parent;

    public Element() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // LAB 5-6 - Evitam referintele circulare in JSON
    @JsonIgnore
    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    // LAB 1 si LAB 2
    public abstract void print();

    // LAB 3 - Visitor
    public abstract void accept(Visitor visitor);

    public void add(Element element) {
        throw new UnsupportedOperationException(
                "Acest element nu poate contine alte elemente."
        );
    }

    public void remove(Element element) {
        throw new UnsupportedOperationException(
                "Acest element nu poate contine alte elemente."
        );
    }

    public Element get(int index) {
        throw new UnsupportedOperationException(
                "Acest element nu poate contine alte elemente."
        );
    }
}
