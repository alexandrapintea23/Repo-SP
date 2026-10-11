
package com.example.designpatternslab.model;

import java.util.concurrent.TimeUnit;

public class Image implements Element {

    private String imageName;

    public Image(String name) {
        this.imageName = name;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + imageName);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException(
                "Cannot add elements to an Image"
        );
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException(
                "Cannot remove elements from an Image"
        );
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException(
                "Cannot get elements from an Image"
        );
    }
}
