package io.github.akotu235.Ratingoo.model.projection;

public class VoteReadModel {
    private VoteStatus status;

    public VoteReadModel(final VoteStatus status) {
        this.status = status;
    }

    public VoteStatus getStatus() {
        return status;
    }

    public void setStatus(final VoteStatus status) {
        this.status = status;
    }
}
