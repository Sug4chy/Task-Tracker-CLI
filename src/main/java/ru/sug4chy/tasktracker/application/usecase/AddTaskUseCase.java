package ru.sug4chy.tasktracker.application.usecase;

import ru.sug4chy.tasktracker.common.result.Result;

public interface AddTaskUseCase {
    Result<Long> add(String description);
}
