
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends Element {

    private String title;

    // LAB 5-6 - Relatie OneToMany intre Section si Element
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SECTION_ID")
    private List<Element> elements = new ArrayList<>();

    // Constructor necesar pentru JPA
    public Section() {
    }

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void print() {
        System.out.println(title);

        for (Element element : elements) {
            element.print();
        }
    }

    // LAB 3 - Visitor
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for (Element element : elements) {
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
                    "Elementul apartine deja unei sectiuni!"
            );
        }

        if (element == this) {
            throw new IllegalArgumentException(
                    "O sectiune nu se poate contine pe ea insasi!"
            );
        }

        Element current = this;

        while (current != null) {
            if (current == element) {
                throw new IllegalArgumentException(
                        "Nu poti crea un ciclu intre sectiuni!"
                );
            }

            current = current.getParent();
        }

        elements.add(element);
        element.setParent(this);
    }

    @Override
    public void remove(Element element) {
        if (elements.remove(element)) {
            element.setParent(null);
        }
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }
}
