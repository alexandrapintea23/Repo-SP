package com.example.designpatternslab.controller;

import com.example.designpatternslab.command.AsyncCommandExecutor;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommandStatusController {

    private final AsyncCommandExecutor asyncCommandExecutor;

    public CommandStatusController(AsyncCommandExecutor asyncCommandExecutor) {
        this.asyncCommandExecutor = asyncCommandExecutor;
    }

    @GetMapping("/commands/{id}/status")
    public String getCommandStatus(@PathVariable String id) {
        return asyncCommandExecutor.getCommandStatus(id);
    }
}