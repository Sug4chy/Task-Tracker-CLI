package ru.sug4chy.tasktracker.application.usecase;

import ru.sug4chy.tasktracker.common.result.Result;
import ru.sug4chy.tasktracker.domain.entity.Task;
import ru.sug4chy.tasktracker.domain.enums.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface ListTasksUseCase {
    Result<List<Task>> list(Optional<TaskStatus> filtrationStatus);
}
