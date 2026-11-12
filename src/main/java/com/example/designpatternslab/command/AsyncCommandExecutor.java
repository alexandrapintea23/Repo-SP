package com.example.designpatternslab.command;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AsyncCommandExecutor {

    private final ExecutorService executorService =
            Executors.newFixedThreadPool(3);

    private final Map<String, String> commandStatuses =
            new ConcurrentHashMap<>();

    public String executeAsync(BookCommand command) {

        String commandId = UUID.randomUUID().toString();

        commandStatuses.put(commandId, "PENDING");

        executorService.submit(() -> {
            commandStatuses.put(commandId, "RUNNING");

            try {
                String result = command.execute();
                commandStatuses.put(commandId, "COMPLETED: " + result);
            } catch (Exception e) {
                commandStatuses.put(commandId, "FAILED: " + e.getMessage());
            }
        });

        return commandId;
    }

    public String getCommandStatus(String commandId) {
        return commandStatuses.getOrDefault(commandId, "NOT_FOUND");
    }

    @PreDestroy
    public void shutdown() {
        executorService.shutdown();
    }
}