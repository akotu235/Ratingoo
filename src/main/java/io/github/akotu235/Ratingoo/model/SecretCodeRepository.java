package io.github.akotu235.Ratingoo.model;

import java.util.Optional;

public interface SecretCodeRepository {
    SecretCode save(SecretCode entity);

    boolean existsBySecretCode(String value);

    Optional<SecretCode> findBySecretCode(String secretCode);

    boolean existsByActiveIsTrueAndSecretCode(String secretCode);
}
