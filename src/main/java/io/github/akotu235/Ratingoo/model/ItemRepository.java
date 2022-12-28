package io.github.akotu235.Ratingoo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    List<Item> findAll();

    Page<Item> findAll(Pageable page);

    Optional<Item> findById(Integer id);

    boolean existsById(Integer id);

    Item save(Item entity);
}
