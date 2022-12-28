package io.github.akotu235.Ratingoo.model.projection;

import io.github.akotu235.Ratingoo.model.Category;
import io.github.akotu235.Ratingoo.model.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemWriteModel {
    @NotBlank(message = "Name cannot be empty.")
    private String name;
    @NotNull(message = "Category cannot be null.")
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public Item toItem(Category category) {
        return new Item(name, category);
    }
}
