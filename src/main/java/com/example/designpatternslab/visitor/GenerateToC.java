
package com.example.designpatternslab.visitor;

import com.example.designpatternslab.model.*;

public class GenerateToC implements Visitor {

    private int level = 0;

    @Override
    public void visit(Book book) {
        System.out.println("Table of Contents - " + book.getTitle());
    }

    @Override
    public void visit(Section section) {
        int depth = 0;
        Element parent = section.getParent();

        while (parent != null) {
            if (parent instanceof Section) {
                depth++;
            }
            parent = parent.getParent();
        }

        System.out.println("  ".repeat(depth) + section.getTitle());
    }

    @Override
    public void visit(Paragraph paragraph) {
        // Paragrafele nu apar in cuprins
    }

    @Override
    public void visit(Image image) {
        // Imaginile nu apar in cuprins
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        // Imaginile Proxy nu apar in cuprins
    }

    @Override
    public void visit(Table table) {
        // Tabelele nu apar in cuprins
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        // Nu adaugam cuprinsul in propriul cuprins
    }
}
