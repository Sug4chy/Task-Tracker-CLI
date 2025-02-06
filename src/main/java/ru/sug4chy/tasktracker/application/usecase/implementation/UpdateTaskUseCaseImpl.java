package ru.sug4chy.tasktracker.application.usecase.implementation;

import lombok.RequiredArgsConstructor;
import ru.sug4chy.tasktracker.application.exception.TaskNotFoundException;
import ru.sug4chy.tasktracker.application.repository.TaskRepository;
import ru.sug4chy.tasktracker.application.usecase.UpdateTaskUseCase;
import ru.sug4chy.tasktracker.application.validation.GlobalValidator;
import ru.sug4chy.tasktracker.common.emptyresult.EmptyResult;
import ru.sug4chy.tasktracker.common.emptyresult.Failure;
import ru.sug4chy.tasktracker.domain.entity.Task;

@RequiredArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepository taskRepository;

    @Override
    public EmptyResult update(long id, String description) {
        if (GlobalValidator.validateId(id) instanceof Failure fail) {
            return fail;
        }

        if (GlobalValidator.validateDescription(description) instanceof Failure fail) {
            return fail;
        }

        var maybeTask = taskRepository.findById(id);
        if (maybeTask.isEmpty()) {
            return EmptyResult.failure(new TaskNotFoundException());
        }

        Task task = maybeTask.get();
        taskRepository.update(task.withDescription(description));

        return EmptyResult.success();
    }
}
