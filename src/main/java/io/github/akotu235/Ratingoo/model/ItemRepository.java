package io.github.akotu235.Ratingoo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    List<Item> findAll();

    Page<Item> findAll(Pageable page);
    List<Item> findAllByCategory(Category category);

    Optional<Item> findById(Integer id);

    List<Item> findByName(String name);

    boolean existsById(Integer id);

    boolean existsByNameAndCategory_Id(String name, Integer categoryId);

    Item save(Item entity);
}
