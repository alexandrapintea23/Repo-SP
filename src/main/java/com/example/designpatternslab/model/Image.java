
package com.example.designpatternslab.model;

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

    @Override
    public void print() {
        System.out.println("Image with name: " + imageName);
    }
}
