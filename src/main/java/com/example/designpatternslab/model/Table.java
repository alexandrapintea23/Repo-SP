
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;

public class Table extends Element {

    private String title;

    public Table(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void print() {
        System.out.println("Table: " + title);
    }

    // LAB 3 - Visitor
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
