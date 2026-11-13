
package com.example.designpatternslab.observer;

import com.example.designpatternslab.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// LAB 7 - Concrete Subject din Observer Pattern
@Component
public class AllBooksSubject {

    private final List<Observer> observers =
            new CopyOnWriteArrayList<>();

    // Inregistram un observator nou
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Eliminam un observator
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // Anuntam toti observatorii despre cartea noua
    public void add(Book book) {
        notifyObservers(book);
    }

    private void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}
