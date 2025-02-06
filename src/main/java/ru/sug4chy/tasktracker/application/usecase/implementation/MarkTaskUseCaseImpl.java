package ru.sug4chy.tasktracker.application.usecase.implementation;

import lombok.RequiredArgsConstructor;
import ru.sug4chy.tasktracker.application.exception.TaskNotFoundException;
import ru.sug4chy.tasktracker.application.repository.TaskRepository;
import ru.sug4chy.tasktracker.application.usecase.MarkTaskUseCase;
import ru.sug4chy.tasktracker.application.validation.GlobalValidator;
import ru.sug4chy.tasktracker.common.emptyresult.EmptyResult;
import ru.sug4chy.tasktracker.common.emptyresult.Failure;
import ru.sug4chy.tasktracker.domain.enums.TaskStatus;

@RequiredArgsConstructor
public class MarkTaskUseCaseImpl implements MarkTaskUseCase {

    private final TaskRepository taskRepository;

    @Override
    public EmptyResult mark(long id, TaskStatus status) {
        if (GlobalValidator.validateId(id) instanceof Failure fail) {
            return fail;
        }

        if (status == null || status == TaskStatus.TODO) {
            return EmptyResult.failure(new IllegalArgumentException("Illegal task status"));
        }

        var task = taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);

        switch (status) {
            case IN_PROGRESS -> taskRepository.update(task.markAsInProgress());
            case DONE -> taskRepository.update(task.markAsDone());
        }

        return EmptyResult.success();
    }
}
