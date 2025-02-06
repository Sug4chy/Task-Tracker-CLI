package ru.sug4chy.tasktracker.application.usecase.implementation;

import lombok.RequiredArgsConstructor;
import ru.sug4chy.tasktracker.application.repository.TaskRepository;
import ru.sug4chy.tasktracker.application.usecase.ListTasksUseCase;
import ru.sug4chy.tasktracker.common.result.Result;
import ru.sug4chy.tasktracker.domain.entity.Task;
import ru.sug4chy.tasktracker.domain.enums.TaskStatus;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ListTasksUseCaseImpl implements ListTasksUseCase {

    private final TaskRepository taskRepository;

    @Override
    public Result<List<Task>> list(Optional<TaskStatus> filtrationStatus) {
        if (filtrationStatus.isPresent()) {
            return taskRepository.findAllWithStatus(filtrationStatus.get());
        } else {
            return taskRepository.findAll();
        }
    }
}
