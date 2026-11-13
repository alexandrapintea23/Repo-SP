
package com.example.designpatternslab.service;

import com.example.designpatternslab.model.Book;
import com.example.designpatternslab.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BookRepository bookRepository;

    // Spring injecteaza automat repository-ul
    public BooksService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // LAB 4 + LAB 5-6: citim cartile din baza de date
    public List<String> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(Book::getTitle)
                .toList();
    }

    // Cautam cartea dupa ID-ul real din baza de date
    public String getBookById(Long id) {
        return bookRepository.findById(id)
                .map(Book::getTitle)
                .orElse("Cartea nu a fost gasita");
    }

    // Salvam cartea in H2
    public String addBook(String title) {
        Book book = new Book(title);
        bookRepository.save(book);

        return "Cartea '" + title + "' a fost adaugata cu succes";
    }

    // Actualizam titlul cartii in H2
    public String updateBook(Long id, String newTitle) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newTitle);
                    bookRepository.save(book);

                    return "Cartea cu ID-ul " + id
                            + " a fost actualizata cu succes";
                })
                .orElse("Cartea nu a fost gasita");
    }

    // Stergem cartea din H2
    public String deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            return "Cartea nu a fost gasita";
        }

        bookRepository.deleteById(id);

        return "Cartea cu ID-ul " + id + " a fost stearsa cu succes";
    }
}

