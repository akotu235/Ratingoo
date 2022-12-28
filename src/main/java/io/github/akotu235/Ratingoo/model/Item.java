package io.github.akotu235.Ratingoo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name cannot be empty.")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private int counter;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Set<Vote> votes;
    @Embedded
    private final Audit audit = new Audit();

    Item() {
    }

    public Item(final String name, final Category category) {
        this.name = name;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    void setCategory(final Category category) {
        this.category = category;
    }

    public int getCounter() {
        return counter;
    }

    void setCounter(final int counter) {
        this.counter = counter;
    }

    public void addVote() {
        this.counter++;
    }
}
