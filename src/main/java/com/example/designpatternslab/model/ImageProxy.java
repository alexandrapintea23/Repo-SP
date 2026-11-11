
package com.example.designpatternslab.model;

public class ImageProxy extends Element {

    private String imageName;
    private Image realImage;

    public ImageProxy(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void print() {
        if (realImage == null) {
            realImage = new Image(imageName);
        }

        realImage.print();
    }
}
