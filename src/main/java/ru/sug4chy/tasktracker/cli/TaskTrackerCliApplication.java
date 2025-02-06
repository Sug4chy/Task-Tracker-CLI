package ru.sug4chy.tasktracker.cli;

import ru.sug4chy.tasktracker.application.repository.InMemoryTaskRepository;
import ru.sug4chy.tasktracker.application.usecase.implementation.AddTaskUseCaseImpl;

import java.util.Scanner;

public class TaskTrackerCliApplication {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new AddTaskUseCaseImpl(new InMemoryTaskRepository()).add(scanner.nextLine());
        }
    }
}
