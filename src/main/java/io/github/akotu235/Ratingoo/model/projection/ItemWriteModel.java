package io.github.akotu235.Ratingoo.model.projection;

import io.github.akotu235.Ratingoo.model.Category;
import io.github.akotu235.Ratingoo.model.Item;

public class ItemWriteModel {
    private String name;
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
