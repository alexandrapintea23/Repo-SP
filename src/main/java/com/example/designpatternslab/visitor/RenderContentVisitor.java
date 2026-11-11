
package com.example.designpatternslab.visitor;

import com.example.designpatternslab.model.*;

public class RenderContentVisitor implements Visitor {

    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle());
    }

    @Override
    public void visit(Section section) {
        System.out.println(section.getTitle());
    }

    @Override
    public void visit(Paragraph paragraph) {

        if (paragraph.getAlignStrategy() == null) {
            System.out.println("Paragraph: " + paragraph.getText());
        } else {
            paragraph.getAlignStrategy().render(paragraph.getText());
        }
    }

    @Override
    public void visit(Image image) {
        System.out.println("Image with name: " + image.getImageName());
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        System.out.println("DEBUG: Am intrat in visit(ImageProxy)");

        Image realImage = imageProxy.getRealImage();

        System.out.println("DEBUG: Imaginea reala a fost incarcata");

        visit(realImage);
    }

    @Override
    public void visit(Table table) {
        System.out.println("Table: " + table.getTitle());
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        System.out.println("Table of Contents");
    }
}
