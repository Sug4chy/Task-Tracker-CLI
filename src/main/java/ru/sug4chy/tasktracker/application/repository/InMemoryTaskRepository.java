package ru.sug4chy.tasktracker.application.repository;

import ru.sug4chy.tasktracker.domain.entity.Task;
import ru.sug4chy.tasktracker.domain.enums.TaskStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTaskRepository implements TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public long lastAddedId() {
        return tasks.size();
    }

    @Override
    public void add(Task task) {
        tasks.add(task);
        System.out.println(task.getId());
    }

    @Override
    public Optional<Task> findById(long id) {
        return tasks
                .stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    @Override
    public void update(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                tasks.set(i, task);
                break;
            }
        }
    }

    @Override
    public void deleteById(long id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Task> findAll() {
        return List.copyOf(tasks);
    }

    @Override
    public List<Task> findAllWithStatus(TaskStatus status) {
        return tasks
                .stream()
                .filter(task -> task.getStatus() == status)
                .toList();
    }
}
