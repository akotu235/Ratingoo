package io.github.akotu235.Ratingoo.validator;

import io.github.akotu235.Ratingoo.model.SecretCodeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class SecretCodeValidator implements ConstraintValidator<ValidSecretCode, String> {

    private final SecretCodeRepository secretCodeRepository;

    public SecretCodeValidator(final SecretCodeRepository secretCodeRepository) {
        this.secretCodeRepository = secretCodeRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return secretCodeRepository.existsByActiveIsTrueAndSecretCode(value);
    }
}