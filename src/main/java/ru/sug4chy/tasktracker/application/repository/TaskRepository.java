package ru.sug4chy.tasktracker.application.repository;

import ru.sug4chy.tasktracker.domain.entity.Task;
import ru.sug4chy.tasktracker.domain.enums.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    long lastAddedId();
    void add(Task task);
    Optional<Task> findById(long id);
    void update(Task task);
    void deleteById(long id);
    List<Task> findAll();
    List<Task> findAllWithStatus(TaskStatus status);
}
