package io.github.akotu235.Ratingoo.model.projection;


import io.github.akotu235.Ratingoo.model.Category;
import jakarta.validation.constraints.NotBlank;

public class CategoryWriteModel {
    @NotBlank(message = "Name cannot be empty.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Category toCategory(String name) {
        return new Category(name);
    }

}
