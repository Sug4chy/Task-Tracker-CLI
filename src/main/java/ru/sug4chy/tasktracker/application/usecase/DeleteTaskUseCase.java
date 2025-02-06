package ru.sug4chy.tasktracker.application.usecase;

import ru.sug4chy.tasktracker.common.emptyresult.EmptyResult;

public interface DeleteTaskUseCase {
    EmptyResult delete(long id);
}
