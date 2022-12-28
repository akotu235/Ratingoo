package io.github.akotu235.Ratingoo.model.projection;


import io.github.akotu235.Ratingoo.model.Item;

public class ItemReadModel {
    private int id;
    private String name;
    private int categoryId;

    private int counter;

    public ItemReadModel(final Item source) {
        this.id = source.getId();
        this.name = source.getName();
        this.categoryId = source.getCategory().getId();
        this.counter = source.getCounter();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(final int counter) {
        this.counter = counter;
    }
}
