
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;

public class TableOfContents extends Element {

    @Override
    public void print() {
        System.out.println("Table of Contents");
    }

    // LAB 3 - Visitor
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
