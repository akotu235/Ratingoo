package io.github.akotu235.Ratingoo.exceptions;

public class InvalidCategoryNameException extends IllegalArgumentException{
    public InvalidCategoryNameException(String message) {
        super(message);
    }
}
