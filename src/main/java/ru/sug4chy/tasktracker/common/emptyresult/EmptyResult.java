package ru.sug4chy.tasktracker.common.emptyresult;

public sealed interface EmptyResult permits EmptySuccess, Failure {
    boolean isSuccess();
    boolean isFailure();

    static EmptyResult success() {
        return new EmptySuccess();
    }

    static EmptyResult failure(Exception e) {
        return new Failure(e);
    }
}
