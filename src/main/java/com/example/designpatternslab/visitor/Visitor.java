package com.example.designpatternslab.visitor;

import com.example.designpatternslab.model.Book;
import com.example.designpatternslab.model.Section;
import com.example.designpatternslab.model.Paragraph;
import com.example.designpatternslab.model.Image;
import com.example.designpatternslab.model.ImageProxy;
import com.example.designpatternslab.model.Table;
import com.example.designpatternslab.model.TableOfContents;

public interface Visitor {

    void visit(Book book);

    void visit(Section section);

    void visit(Paragraph paragraph);

    void visit(Image image);

    void visit(ImageProxy imageProxy);

    void visit(Table table);

    void visit(TableOfContents tableOfContents);
}