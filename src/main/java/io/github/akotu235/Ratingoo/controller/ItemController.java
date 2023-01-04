package io.github.akotu235.Ratingoo.controller;

import io.github.akotu235.Ratingoo.exceptions.InvalidItemNameException;
import io.github.akotu235.Ratingoo.logic.ItemService;
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
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/items")
class ItemController {
    private final ItemRepository repository;
    private final ItemService itemService;


    ItemController(final ItemRepository repository, final ItemService itemService) {
        this.repository = repository;
        this.itemService = itemService;
    }

    @GetMapping(params = {"!sort", "!page", "!size"})
    ResponseEntity<List<ItemReadModel>> readAllTasks() {
        return ResponseEntity.ok(repository.findAll().stream().map(ItemReadModel::new).collect(Collectors.toList()));
    }

    @GetMapping
    ResponseEntity<List<ItemReadModel>> readAllTasks(Pageable page) {
        return ResponseEntity.ok(repository.findAll(page).getContent().stream().map(ItemReadModel::new).collect(Collectors.toList()));
    }

    @PostMapping
    ResponseEntity<ItemReadModel> createItem(@RequestBody @Valid ItemWriteModel item) {
        ItemReadModel result = itemService.createItem(item);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path("/item" + result.getId()).build().toUri()).body(result);
    }

    @ExceptionHandler(InvalidItemNameException.class)
    ResponseEntity<ExceptionReadModel> handleInvalidItemName(InvalidItemNameException e) {
        return ResponseEntity.badRequest().body(new ExceptionReadModel(e.getMessage()));
    }
}
