
package com.example.designpatternslab.model;

public class AlignCenter implements AlignStrategy {

    @Override
    public void render(String text) {
        System.out.println("Align Center: " + text);
    }
}
