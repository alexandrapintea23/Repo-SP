
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class ImageProxy extends Element {

    private String imageName;

    @Transient
    private Image realImage;

    // Constructor necesar pentru JPA
    public ImageProxy() {
    }

    public ImageProxy(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    // LAB 2 - Proxy: incarcare intarziata
    public Image getRealImage() {
        if (realImage == null) {
            realImage = new Image(imageName);
        }

        return realImage;
    }

    @Override
    public void print() {
        getRealImage().print();
    }

    // LAB 3 - Visitor
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
