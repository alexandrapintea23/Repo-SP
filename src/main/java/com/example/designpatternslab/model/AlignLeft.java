
package com.example.designpatternslab.model;

public class AlignLeft implements AlignStrategy {

    @Override
    public void render(String text) {
        System.out.println("Align Left: " + text);
    }
}
