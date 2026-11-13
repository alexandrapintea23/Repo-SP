
package com.example.designpatternslab.controller;

import com.example.designpatternslab.observer.AllBooksSubject;
import com.example.designpatternslab.observer.SseObserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

// LAB 7 - Controller pentru Server-Sent Events
@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books-sse")
    public SseEmitter getBooksSse() {

        // 0L = conexiunea nu expira automat
        SseEmitter emitter = new SseEmitter(0L);

        // Inregistram un observator pentru browser
        SseObserver observer = new SseObserver(emitter);
        allBooksSubject.attach(observer);

        // Eliminam observatorul cand conexiunea se inchide
        emitter.onCompletion(() -> allBooksSubject.detach(observer));
        emitter.onTimeout(() -> allBooksSubject.detach(observer));
        emitter.onError(error -> allBooksSubject.detach(observer));

        return emitter;
    }
}
