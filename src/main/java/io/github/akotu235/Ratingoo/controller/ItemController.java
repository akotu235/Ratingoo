package io.github.akotu235.Ratingoo.controller;

import io.github.akotu235.Ratingoo.exceptions.InvalidCategoryNameException;
import io.github.akotu235.Ratingoo.exceptions.InvalidItemNameException;
import io.github.akotu235.Ratingoo.logic.CategoryService;
import io.github.akotu235.Ratingoo.logic.ItemService;
import io.github.akotu235.Ratingoo.model.Category;
import io.github.akotu235.Ratingoo.model.ItemRepository;
import io.github.akotu235.Ratingoo.model.projection.ExceptionReadModel;
import io.github.akotu235.Ratingoo.model.projection.ItemReadModel;
import io.github.akotu235.Ratingoo.model.projection.ItemWriteModel;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/items")
class ItemController {
    private final ItemRepository repository;
    private final ItemService itemService;
    private final CategoryService categoryService;


    ItemController(final ItemRepository repository, final ItemService itemService, CategoryService categoryService) {
        this.repository = repository;
        this.itemService = itemService;
        this.categoryService = categoryService;
    }

    @GetMapping(params = {"!sort", "!page", "!size"})
    ResponseEntity<List<ItemReadModel>> readAllItems() {
        return ResponseEntity.ok(repository.findAll().stream().map(ItemReadModel::new).collect(Collectors.toList()));
    }

    @GetMapping
    ResponseEntity<List<ItemReadModel>> readAllItems(Pageable page) {
        return ResponseEntity.ok(repository.findAll(page).getContent().stream().map(ItemReadModel::new).collect(Collectors.toList()));
    }

    @GetMapping("/{categoryName}")
    ResponseEntity<List<ItemReadModel>> readCategoryItems(@PathVariable String categoryName) {
        Optional<Category> category = categoryService.getCategory(categoryName);
        if(category.isPresent()){
            return ResponseEntity.ok(repository.findAllByCategory(category.get()).stream().map(ItemReadModel::new).collect(Collectors.toList()));
        }
        throw new InvalidCategoryNameException("Category '" + categoryName + "' does not exist.");
    }

    @PostMapping
    ResponseEntity<ItemReadModel> createItem(@RequestBody @Valid ItemWriteModel item) {
        ItemReadModel result = itemService.createItem(item);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path("/item" + result.getId()).build().toUri()).body(result);
    }

    @ExceptionHandler({InvalidItemNameException.class})
    ResponseEntity<ExceptionReadModel> handleInvalidItemName(InvalidItemNameException e) {
        return ResponseEntity.badRequest().body(new ExceptionReadModel(e.getMessage()));
    }
    @ExceptionHandler({InvalidCategoryNameException.class})
    ResponseEntity<ExceptionReadModel> handleInvalidCategoryName(InvalidCategoryNameException e) {
        return ResponseEntity.badRequest().body(new ExceptionReadModel(e.getMessage()));
    }
}
