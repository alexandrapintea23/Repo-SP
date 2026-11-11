package com.example.designpatternslab.repository;

import com.example.designpatternslab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}