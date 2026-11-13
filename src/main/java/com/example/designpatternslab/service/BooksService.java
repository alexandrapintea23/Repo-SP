
package com.example.designpatternslab.service;

import com.example.designpatternslab.model.Book;
import com.example.designpatternslab.observer.AllBooksSubject;
import com.example.designpatternslab.persistence.CrudRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final CrudRepository<Book, Long> bookRepository;
    private final AllBooksSubject allBooksSubject;

    public BooksService(
            CrudRepository<Book, Long> bookRepository,
            AllBooksSubject allBooksSubject
    ) {
        this.bookRepository = bookRepository;
        this.allBooksSubject = allBooksSubject;
    }

    // LAB 4 + LAB 5-6 - Citim titlurile din baza de date
    public List<String> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(Book::getTitle)
                .toList();
    }

    // Cautam titlul cartii dupa ID
    public String getBookById(Long id) {
        return bookRepository.findById(id)
                .map(Book::getTitle)
                .orElse("Cartea nu a fost gasita");
    }

    // LAB 5-6 - Returnam obiectele Book pentru JSON
    public List<Book> getAllBooksAsObjects() {
        return bookRepository.findAll();
    }

    // LAB 5-6 - Returnam o carte completa dupa ID
    public Optional<Book> getBookAsObjectById(Long id) {
        return bookRepository.findById(id);
    }

    // LAB 7 - Salvam cartea si notificam observatorii
    public String addBook(String title) {
        Book book = new Book(title);

        // Salvam cartea si obtinem ID-ul generat
        book = bookRepository.save(book);

        // Observer Pattern - notificam browserul
        allBooksSubject.add(book);

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
