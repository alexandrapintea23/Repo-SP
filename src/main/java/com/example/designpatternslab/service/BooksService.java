package com.example.designpatternslab.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    private final List<String> books = new ArrayList<>();

    public BooksService() {
        books.add("Noapte buna, copii!");
        books.add("Ion");
        books.add("Morometii");
    }

    public List<String> getAllBooks() {
        return books;
    }

    public String getBookById(Long id) {
        int index = id.intValue() - 1;

        if (index < 0 || index >= books.size()) {
            return "Cartea nu a fost gasita";
        }

        return books.get(index);
    }

    public String addBook(String title) {
        books.add(title);
        return "Cartea '" + title + "' a fost adaugata cu succes";
    }

    public String updateBook(Long id, String newTitle) {
        int index = id.intValue() - 1;

        if (index < 0 || index >= books.size()) {
            return "Cartea nu a fost gasita";
        }

        books.set(index, newTitle);
        return "Cartea cu ID-ul " + id + " a fost actualizata cu succes";
    }

    public String deleteBook(Long id) {
        int index = id.intValue() - 1;

        if (index < 0 || index >= books.size()) {
            return "Cartea nu a fost gasita";
        }

        books.remove(index);
        return "Cartea cu ID-ul " + id + " a fost stearsa cu succes";
    }
}