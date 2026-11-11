
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;

public class Paragraph extends Element {

    private String text;

    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public AlignStrategy getAlignStrategy() {
        return alignStrategy;
    }

    @Override
    public void print() {

        if (alignStrategy == null) {
            System.out.println("Paragraph: " + text);
        } else {
            alignStrategy.render(text);
        }
    }

    // LAB 3 - Visitor
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
