
package com.example.designpatternslab.model;

import com.example.designpatternslab.visitor.Visitor;
import jakarta.persistence.Entity;

import java.util.concurrent.TimeUnit;

@Entity
public class Image extends Element {

    private String imageName;

    // Constructor necesar pentru JPA
    public Image() {
    }

    public Image(String name) {
        this.imageName = name;

        // LAB 2 - simulam incarcarea imaginii
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
