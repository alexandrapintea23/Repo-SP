
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;
import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "BookTable")
public class Table extends Element {

    private String title;

    // Constructor necesar pentru JPA
    public Table() {
    }

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
