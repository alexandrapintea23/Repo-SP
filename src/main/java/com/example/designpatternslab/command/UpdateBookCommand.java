package com.example.designpatternslab.command;

import com.example.designpatternslab.service.BooksService;

public class UpdateBookCommand implements BookCommand {

    private final BooksService booksService;
    private final Long id;
    private final String newTitle;

    public UpdateBookCommand(BooksService booksService, Long id, String newTitle) {
        this.booksService = booksService;
        this.id = id;
        this.newTitle = newTitle;
    }

    @Override
    public String execute() {
        return booksService.updateBook(id, newTitle);
    }
}