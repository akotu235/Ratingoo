package io.github.akotu235.Ratingoo.validator;

import io.github.akotu235.Ratingoo.model.ItemRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ItemIdValidator implements ConstraintValidator<ValidItemId, Integer> {

    private final ItemRepository itemRepository;

    public ItemIdValidator(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return itemRepository.existsById(value);
    }
}