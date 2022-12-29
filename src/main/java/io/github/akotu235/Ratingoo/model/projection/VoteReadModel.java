package io.github.akotu235.Ratingoo.model.projection;

public class VoteReadModel {
    private Status status;

    public VoteReadModel(final Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
