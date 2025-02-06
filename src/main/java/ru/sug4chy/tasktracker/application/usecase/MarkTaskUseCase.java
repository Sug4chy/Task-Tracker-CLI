package ru.sug4chy.tasktracker.application.usecase;

import ru.sug4chy.tasktracker.common.emptyresult.EmptyResult;
import ru.sug4chy.tasktracker.domain.enums.TaskStatus;

public interface MarkTaskUseCase {
    EmptyResult mark(long id, TaskStatus status);
}
