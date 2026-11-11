
package com.example.designpatternslab.model;

public abstract class Element {

    private Element parent;

    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    public abstract void print();

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
