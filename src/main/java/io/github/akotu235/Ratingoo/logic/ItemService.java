package io.github.akotu235.Ratingoo.logic;

import io.github.akotu235.Ratingoo.model.Category;
import io.github.akotu235.Ratingoo.model.Item;
import io.github.akotu235.Ratingoo.model.ItemRepository;
import io.github.akotu235.Ratingoo.model.projection.ItemReadModel;
import io.github.akotu235.Ratingoo.model.projection.ItemWriteModel;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;

    ItemService(final ItemRepository itemRepository, final CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
    }

//    TODO: dodać sprawdzenie czy item z daną nazwą i kategorią już istnieje
    public ItemReadModel createItem(ItemWriteModel source) {
        Category category = categoryService.getCategory(source.getCategory().getName()).orElseThrow(()-> new IllegalArgumentException("Category with given id not found."));
        Item result = itemRepository.save(source.toItem(category));
        return new ItemReadModel(result);
    }
}
