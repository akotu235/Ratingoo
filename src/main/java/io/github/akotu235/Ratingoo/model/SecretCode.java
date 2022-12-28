package io.github.akotu235.Ratingoo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "secret_codes")
public class SecretCode {
    @Id
    private String secretCode;
    private boolean active;

    SecretCode() {
    }

    String getSecretCode() {
        return secretCode;
    }

    void setSecretCode(final String secretCode) {
        this.secretCode = secretCode;
    }

    boolean isActive() {
        return active;
    }

    void setActive(final boolean active) {
        this.active = active;
    }
}
