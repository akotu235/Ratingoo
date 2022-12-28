package io.github.akotu235.Ratingoo.model.projection;

import io.github.akotu235.Ratingoo.model.Category;

public class CategoryReadModel {
    private String name;

    public CategoryReadModel(final Category source) {
        this.name = source.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
