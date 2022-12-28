package io.github.akotu235.Ratingoo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private String secretCode;
    @Embedded
    private final Audit audit = new Audit();

    Vote() {
    }

    public Vote(final Item item, final String secretCode) {
        this.item = item;
        this.secretCode = secretCode;
    }

    int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    Item getItemId() {
        return item;
    }

    void setItemId(final Item itemId) {
        this.item = itemId;
    }

    Item getItem() {
        return item;
    }

    void setItem(final Item item) {
        this.item = item;
    }

    String getSecretCode() {
        return secretCode;
    }

    void setSecretCode(final String secretCode) {
        this.secretCode = secretCode;
    }
}
