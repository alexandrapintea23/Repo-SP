package com.example.designpatternslab.command;

import org.springframework.stereotype.Component;

@Component
public class BookCommandExecutor {

    public String executeCommand(BookCommand command) {
        return command.execute();
    }
}