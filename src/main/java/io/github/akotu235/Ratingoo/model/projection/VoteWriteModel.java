package io.github.akotu235.Ratingoo.model.projection;

import io.github.akotu235.Ratingoo.validator.ValidItemId;
import io.github.akotu235.Ratingoo.validator.ValidSecretCode;

public class VoteWriteModel {
    @ValidItemId
    private int itemId;
    @ValidSecretCode
    private String secretCode;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(final int itemId) {
        this.itemId = itemId;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(final String secretCode) {
        this.secretCode = secretCode;
    }
}
