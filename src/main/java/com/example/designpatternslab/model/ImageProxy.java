
package com.example.designpatternslab.model;

public class ImageProxy implements Element {

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

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException(
                "Cannot add elements to an ImageProxy"
        );
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException(
                "Cannot remove elements from an ImageProxy"
        );
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException(
                "Cannot get elements from an ImageProxy"
        );
    }
}
