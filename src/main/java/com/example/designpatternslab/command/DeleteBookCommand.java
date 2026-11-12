package com.example.designpatternslab.command;

import com.example.designpatternslab.service.BooksService;

public class DeleteBookCommand implements BookCommand {

    private final BooksService booksService;
    private final Long id;

    public DeleteBookCommand(BooksService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public String execute() {
        return booksService.deleteBook(id);
    }
}