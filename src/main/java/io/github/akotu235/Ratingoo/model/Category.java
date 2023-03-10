package io.github.akotu235.Ratingoo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    @NotBlank(message = "Category name cannot be empty.")
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Item> Items;
    @Embedded
    private final Audit audit = new Audit();

    Category() {
    }

    public Category(final String name) {
        this.name = name;
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

}
