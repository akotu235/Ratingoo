package io.github.akotu235.Ratingoo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private int counter;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Set<Vote> votes;


    Item() {
    }


    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    Category getCategory() {
        return category;
    }

    void setCategory(final Category category) {
        this.category = category;
    }

    int getCounter() {
        return counter;
    }

    void setCounter(final int counter) {
        this.counter = counter;
    }
}