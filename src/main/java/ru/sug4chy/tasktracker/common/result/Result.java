package ru.sug4chy.tasktracker.common.result;

public sealed interface Result<T> permits Failure, Success {
    static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    static <T> Result<T> failure(Exception e) {
        return new Failure<>(e);
    }

    boolean isSuccess();

    boolean isFailure();
}
