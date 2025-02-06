package ru.sug4chy.tasktracker.application.usecase.implementation;

import lombok.RequiredArgsConstructor;
import ru.sug4chy.tasktracker.application.repository.TaskRepository;
import ru.sug4chy.tasktracker.application.usecase.AddTaskUseCase;
import ru.sug4chy.tasktracker.application.validation.GlobalValidator;
import ru.sug4chy.tasktracker.common.emptyresult.Failure;
import ru.sug4chy.tasktracker.common.result.Result;
import ru.sug4chy.tasktracker.domain.entity.Task;

import static ru.sug4chy.tasktracker.common.result.Result.*;

@RequiredArgsConstructor
public class AddTaskUseCaseImpl implements AddTaskUseCase {

    private final TaskRepository taskRepository;

    @Override
    public Result<Long> add(String description) {
        if (GlobalValidator.validateDescription(description) instanceof Failure(Exception error)) {
            return failure(error);
        }

        long newId = calculateNewId();
        Task task = Task.of(newId, description);
        taskRepository.add(task);

        return success(newId);
    }

    private long calculateNewId() {
        return taskRepository.lastAddedId() + 1L;
    }
}
