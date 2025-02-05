package ru.sug4chy.tasktracker.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

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

        return new Task(
                id,
                description,
                TaskStatus.TODO,
                now,
                now
        );
    }

    public Task setDescription(String description) {
        this.description = description;
        this.updatedAt = Instant.now().getEpochSecond();

        return this;
    }

    public Task markAsInProgress() {
        this.status = TaskStatus.IN_PROGRESS;
        this.updatedAt = Instant.now().getEpochSecond();

        return this;
    }

    public Task markAsDone() {
        this.status = TaskStatus.DONE;
        this.updatedAt = Instant.now().getEpochSecond();

        return this;
    }
}
