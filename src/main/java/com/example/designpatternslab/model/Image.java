
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;
import java.util.concurrent.TimeUnit;

public class Image extends Element {

    private String imageName;

    public Image(String name) {
        this.imageName = name;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getImageName() {
        return imageName;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + imageName);
    }

    // LAB 3 - Visitor
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
