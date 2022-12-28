package io.github.akotu235.Ratingoo.adapter;

import io.github.akotu235.Ratingoo.model.Item;
import io.github.akotu235.Ratingoo.model.ItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlItemRepository extends ItemRepository, JpaRepository<Item, Integer> {
}
