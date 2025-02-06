package ru.sug4chy.tasktracker.common.emptyresult;

public record Failure(Exception error) implements EmptyResult {
    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isFailure() {
        return true;
    }
}
