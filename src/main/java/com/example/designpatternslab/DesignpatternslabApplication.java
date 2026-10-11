
package com.example.designpatternslab;

import com.example.designpatternslab.model.ImageProxy;
import com.example.designpatternslab.model.Section;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignpatternslabApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                DesignpatternslabApplication.class, args
        );

        long startTime = System.currentTimeMillis();

        // Cream imaginile folosind Proxy
        ImageProxy img1 = new ImageProxy("Pamela Anderson");
        ImageProxy img2 = new ImageProxy("Kim Kardashian");
        ImageProxy img3 = new ImageProxy("Kirby Griffin");

        // Prima sectiune
        Section section1 = new Section("Front Cover");
        section1.add(img1);

        // A doua sectiune
        Section section2 = new Section("Summer Girls");
        section2.add(img2);
        section2.add(img3);

        long endTime = System.currentTimeMillis();

        System.out.println(
                "Creation of the content took " +
                        (endTime - startTime) + " milliseconds"
        );

        // Prima afisare
        startTime = System.currentTimeMillis();

        section1.print();

        endTime = System.currentTimeMillis();

        System.out.println(
                "Printing of section 1 took " +
                        (endTime - startTime) + " milliseconds"
        );

        // A doua afisare
        startTime = System.currentTimeMillis();

        section1.print();

        endTime = System.currentTimeMillis();

        System.out.println(
                "Printing again section 1 took " +
                        (endTime - startTime) + " milliseconds"
        );
    }
}
