package io.github.akotu235.Ratingoo.model.projection;

public class ExceptionReadModel {
    private String message;

    public ExceptionReadModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
