
package com.example.designpatternslab.controller;

import com.example.designpatternslab.difexamples.SingletonComponent;
import com.example.designpatternslab.difexamples.TransientComponent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultipleInstancesController {

    private final ApplicationContext context;

    public MultipleInstancesController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/instances")
    public String testInstances() {

        SingletonComponent singleton1 =
                context.getBean(SingletonComponent.class);

        SingletonComponent singleton2 =
                context.getBean(SingletonComponent.class);

        TransientComponent transient1 =
                context.getBean(TransientComponent.class);

        TransientComponent transient2 =
                context.getBean(TransientComponent.class);

        boolean sameSingleton = singleton1 == singleton2;
        boolean sameTransient = transient1 == transient2;

        System.out.println("\n===== LAB 4 - EXERCITIUL 11 =====");
        System.out.println("Singleton - aceeasi instanta? " + sameSingleton);
        System.out.println("Transient - aceeasi instanta? " + sameTransient);

        return "Singleton - aceeasi instanta? " + sameSingleton
                + "\nTransient - aceeasi instanta? " + sameTransient;
    }
}
