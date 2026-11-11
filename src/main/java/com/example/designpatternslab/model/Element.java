
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;

public abstract class Element {

    private Element parent;

    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    // LAB 1 si LAB 2 - pastram momentan metoda print()
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
