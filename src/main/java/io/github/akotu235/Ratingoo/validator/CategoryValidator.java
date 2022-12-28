package io.github.akotu235.Ratingoo.validator;

import io.github.akotu235.Ratingoo.model.Category;
import io.github.akotu235.Ratingoo.model.CategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CategoryValidator implements ConstraintValidator<ValidCategory, Category> {

    private final CategoryRepository categoryRepository;

    public CategoryValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isValid(Category value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return categoryRepository.existsByName(value.getName());
    }
}