package io.github.akotu235.Ratingoo.model.projection;


import io.github.akotu235.Ratingoo.model.Item;

public class ItemReadModel {
    private int id;
    private String name;
    private String category;

    private int counter;

    public ItemReadModel(final Item source) {
        this.id = source.getId();
        this.name = source.getName();
        this.category = source.getCategory().getName();
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

    public String getCategory() {
        return category;
    }

    public void setCategory(final String categoryName) {
        this.category = categoryName;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(final int counter) {
        this.counter = counter;
    }
}
