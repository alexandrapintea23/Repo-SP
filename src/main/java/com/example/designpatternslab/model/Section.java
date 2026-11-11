
package com.example.designpatternslab.model;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {

    private String title;
    private List<Element> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);

        for (Element element : elements) {
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
                    "Elementul apartine deja unei sectiuni!"
            );
        }

        if (element == this) {
            throw new IllegalArgumentException(
                    "O sectiune nu se poate contine pe ea insasi!"
            );
        }

        // Impiedicam si ciclurile intre sectiuni
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
