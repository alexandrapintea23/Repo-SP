
package com.example.designpatternslab.persistence;

import com.example.designpatternslab.model.Book;
import com.example.designpatternslab.repository.BookRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// LAB 5-6 - Persistence Adapter
@Repository
public class BookRepositoryAdapter implements CrudRepository<Book, Long> {

    private final BookRepository bookRepository;

    public BookRepositoryAdapter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean existsById(Long id) {
        return bookRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
