package ru.sug4chy.tasktracker.common.result;

public record Success<T>(T value) implements Result<T> {

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public boolean isFailure() {
        return false;
    }
}
