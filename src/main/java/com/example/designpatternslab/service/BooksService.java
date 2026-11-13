
package com.example.designpatternslab.service;

import com.example.designpatternslab.model.Book;
import com.example.designpatternslab.persistence.CrudRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final CrudRepository<Book, Long> bookRepository;

    // Spring injecteaza implementarea BookRepositoryAdapter
    public BooksService(CrudRepository<Book, Long> bookRepository) {
        this.bookRepository = bookRepository;
    }

    // LAB 4 + LAB 5-6: citim titlurile din baza de date
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
