package com.example.designpatternslab.command;

import com.example.designpatternslab.service.BooksService;

public class AddBookCommand implements BookCommand {

    private final BooksService booksService;
    private final String title;

    public AddBookCommand(BooksService booksService, String title) {
        this.booksService = booksService;
        this.title = title;
    }

    @Override
    public String execute() {
        return booksService.addBook(title);
    }
}