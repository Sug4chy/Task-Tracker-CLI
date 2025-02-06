package ru.sug4chy.tasktracker.application.usecase;

import ru.sug4chy.tasktracker.common.emptyresult.EmptyResult;

public interface UpdateTaskUseCase {
    EmptyResult update(long id, String description);
}
