
package com.example.designpatternslab.controller;

import com.example.designpatternslab.difexamples.SingletonComponent;
import com.example.designpatternslab.difexamples.TransientComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final SingletonComponent singletonComponent;
    private final TransientComponent transientComponent;

    @Autowired
    public HelloController(
            SingletonComponent singletonComponent,
            TransientComponent transientComponent) {

        this.singletonComponent = singletonComponent;
        this.transientComponent = transientComponent;

        System.out.println(
                "HelloController creat cu Dependency Injection!"
        );
    }

    @GetMapping("/")
    public String hello() {

        singletonComponent.operation();
        transientComponent.operation();

        return "Hello from Spring Boot!";
    }
}
