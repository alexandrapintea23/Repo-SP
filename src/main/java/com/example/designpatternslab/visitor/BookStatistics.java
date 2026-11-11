
package com.example.designpatternslab.visitor;

import com.example.designpatternslab.model.*;

public class BookStatistics implements Visitor {

    private int numberOfImages = 0;
    private int numberOfTables = 0;
    private int numberOfParagraphs = 0;

    @Override
    public void visit(Book book) {
        // Nu numaram cartea
    }

    @Override
    public void visit(Section section) {
        // Nu numaram sectiunile
    }

    @Override
    public void visit(Paragraph paragraph) {
        numberOfParagraphs++;
    }

    @Override
    public void visit(Image image) {
        numberOfImages++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        // Proxy-ul este numarat ca imagine,
        // fara sa incarcam imaginea reala
        numberOfImages++;
    }

    @Override
    public void visit(Table table) {
        numberOfTables++;
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        // Nu numaram cuprinsul
    }

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + numberOfImages);
        System.out.println("*** Number of tables: " + numberOfTables);
        System.out.println("*** Number of paragraphs: " + numberOfParagraphs);
    }
}
