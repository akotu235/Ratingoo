package io.github.akotu235.Ratingoo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> findAll();

    Page<Category> findAll(Pageable page);

    Optional<Category> findById(Integer id);

    Optional<Category> findByName(String name);

    boolean existsById(Integer id);

    boolean existsByName(String name);

    Category save(Category entity);
}
