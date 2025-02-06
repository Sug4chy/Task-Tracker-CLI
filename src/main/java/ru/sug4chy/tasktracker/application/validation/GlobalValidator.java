package ru.sug4chy.tasktracker.application.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.sug4chy.tasktracker.common.emptyresult.EmptyResult;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GlobalValidator {

    public static EmptyResult validateDescription(String description) {
        if (description == null) {
            return EmptyResult.failure(
                    new IllegalArgumentException("Description is null")
            );
        }

        if (description.isBlank()) {
            return EmptyResult.failure(
                    new IllegalArgumentException("Description is blank")
            );
        }

        return EmptyResult.success();
    }

    public static EmptyResult validateId(long id) {
        if (id <= 0) {
            return EmptyResult.failure(
                    new IllegalArgumentException("Id isn't positive")
            );
        }

        return EmptyResult.success();
    }
}
