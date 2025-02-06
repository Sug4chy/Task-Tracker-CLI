package ru.sug4chy.tasktracker.common.result;

public record Failure<T>(Exception error) implements Result<T> {

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isFailure() {
        return true;
    }
}
