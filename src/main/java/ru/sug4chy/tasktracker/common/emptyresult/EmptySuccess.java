package ru.sug4chy.tasktracker.common.emptyresult;

public record EmptySuccess() implements EmptyResult {
    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public boolean isFailure() {
        return false;
    }
}
