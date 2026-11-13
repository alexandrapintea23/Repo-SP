package com.example.designpatternslab.repository;

import com.example.designpatternslab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}