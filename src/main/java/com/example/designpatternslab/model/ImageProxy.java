
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;

public class ImageProxy extends Element {

    private String imageName;
    private Image realImage;

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

    // Pastram print() pentru testele vechi din LAB 2
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
