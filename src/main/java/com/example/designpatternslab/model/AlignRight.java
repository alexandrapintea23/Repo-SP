
package com.example.designpatternslab.model;

public class AlignRight implements AlignStrategy {

    @Override
    public void render(String text) {
        System.out.println("Align Right: " + text);
    }
}
