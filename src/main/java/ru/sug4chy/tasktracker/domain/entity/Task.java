package ru.sug4chy.tasktracker.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import ru.sug4chy.tasktracker.domain.enums.TaskStatus;

import java.time.Instant;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Task {
    private long id;
    private String description;
    private TaskStatus status;

    @Getter(AccessLevel.NONE)
    private long createdAt;

    @Getter(AccessLevel.NONE)
    private long updatedAt;

    @NonNull
    public static Task of(long id, String description) {
        long now = Instant.now().getEpochSecond();

        return new Task(id, description, TaskStatus.TODO, now, now);
    }

    public Task withDescription(String description) {
        return new Task(
                this.id,
                description,
                this.status,
                this.createdAt,
                Instant.now().getEpochSecond()
        );
    }

    public Task markAsInProgress() {
        return new Task(
                this.id,
                this.description,
                TaskStatus.IN_PROGRESS,
                this.createdAt,
                Instant.now().getEpochSecond()
        );
    }

    public Task markAsDone() {
        return new Task(
                this.id,
                this.description,
                TaskStatus.DONE,
                this.createdAt,
                Instant.now().getEpochSecond()
        );
    }
}
