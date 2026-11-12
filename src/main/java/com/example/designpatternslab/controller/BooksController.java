package com.example.designpatternslab.controller;

import com.example.designpatternslab.command.AddBookCommand;
import com.example.designpatternslab.command.UpdateBookCommand;
import com.example.designpatternslab.command.DeleteBookCommand;
import com.example.designpatternslab.command.BookCommandExecutor;
import com.example.designpatternslab.command.AsyncCommandExecutor;
import com.example.designpatternslab.service.BooksService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    private final BooksService booksService;
    private final BookCommandExecutor commandExecutor;
    private final AsyncCommandExecutor asyncCommandExecutor;

    public BooksController(
            BooksService booksService,
            BookCommandExecutor commandExecutor,
            AsyncCommandExecutor asyncCommandExecutor
    ) {
        this.booksService = booksService;
        this.commandExecutor = commandExecutor;
        this.asyncCommandExecutor = asyncCommandExecutor;
    }

    @GetMapping("/books")
    public List<String> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable Long id) {
        return booksService.getBookById(id);
    }

    @PostMapping("/books")
    public String createBook(@RequestBody String title) {
        AddBookCommand command = new AddBookCommand(booksService, title);
        return commandExecutor.executeCommand(command);
    }

    @PostMapping("/books/async")
    public ResponseEntity<String> createBookAsync(@RequestBody String title) {

        AddBookCommand command = new AddBookCommand(booksService, title);

        String commandId = asyncCommandExecutor.executeAsync(command);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(commandId);
    }

    @PutMapping("/books/{id}")
    public String updateBook(
            @PathVariable Long id,
            @RequestBody String newTitle
    ) {
        UpdateBookCommand command =
                new UpdateBookCommand(booksService, id, newTitle);

        return commandExecutor.executeCommand(command);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable Long id) {
        DeleteBookCommand command = new DeleteBookCommand(booksService, id);
        return commandExecutor.executeCommand(command);
    }
}