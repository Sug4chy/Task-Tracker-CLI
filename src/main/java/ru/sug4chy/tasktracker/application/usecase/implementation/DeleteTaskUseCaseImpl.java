package ru.sug4chy.tasktracker.application.usecase.implementation;

import lombok.RequiredArgsConstructor;
import ru.sug4chy.tasktracker.application.repository.TaskRepository;
import ru.sug4chy.tasktracker.application.usecase.DeleteTaskUseCase;
import ru.sug4chy.tasktracker.application.validation.GlobalValidator;
import ru.sug4chy.tasktracker.common.emptyresult.EmptyResult;
import ru.sug4chy.tasktracker.common.emptyresult.Failure;

@RequiredArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepository taskRepository;

    @Override
    public EmptyResult delete(long id) {
        if (GlobalValidator.validateId(id) instanceof Failure fail) {
            return fail;
        }

        taskRepository.deleteById(id);

        return EmptyResult.success();
    }
}
