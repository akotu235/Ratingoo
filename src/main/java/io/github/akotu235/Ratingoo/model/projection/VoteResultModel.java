package io.github.akotu235.Ratingoo.model.projection;

public class VoteResultModel {
    private VoteStatus status;

    public VoteResultModel(final VoteStatus status) {
        this.status = status;
    }

    VoteStatus getStatus() {
        return status;
    }

    void setStatus(final VoteStatus status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return status.equals(VoteStatus.SUCCESS);
    }
}
