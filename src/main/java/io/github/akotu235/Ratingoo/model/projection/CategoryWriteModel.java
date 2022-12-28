package io.github.akotu235.Ratingoo.model.projection;


import io.github.akotu235.Ratingoo.model.Category;

public class CategoryWriteModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    //TODO:
    public Category toCategory(String name) {
        return new Category(name);
    }

}
