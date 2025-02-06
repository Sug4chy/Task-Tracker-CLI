package ru.sug4chy.tasktracker.application.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() {
        super("Task wasn't found");
    }
}
