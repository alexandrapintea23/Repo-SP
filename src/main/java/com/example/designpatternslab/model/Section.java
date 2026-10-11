
package com.example.designpatternslab.model;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {

    private String title;
    private List<Element> elements = new ArrayList<>();

    // Constructor
    public Section(String title) {
        this.title = title;
    }

    // Afiseaza sectiunea si elementele sale
    @Override
    public void print() {
        System.out.println(title);

        for (Element element : elements) {
            element.print();
        }
    }

    // Adauga un element in sectiune
    @Override
    public void add(Element element) {
        elements.add(element);
    }

    // Sterge un element din sectiune
    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    // Returneaza elementul de la pozitia index
    @Override
    public Element get(int index) {
        return elements.get(index);
    }
}
