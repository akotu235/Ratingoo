package io.github.akotu235.Ratingoo.controller;

import io.github.akotu235.Ratingoo.logic.CategoryService;
import io.github.akotu235.Ratingoo.model.CategoryRepository;
import io.github.akotu235.Ratingoo.model.projection.CategoryReadModel;
import io.github.akotu235.Ratingoo.model.projection.CategoryWriteModel;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categories")
class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    CategoryController(final CategoryRepository categoryRepository, final CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping(params = {"!sort", "!page", "!size"})
    ResponseEntity<List<CategoryReadModel>> readAllTasks() {
        return ResponseEntity.ok(categoryRepository.findAll().stream().map(CategoryReadModel::new).collect(Collectors.toList()));
    }

    @GetMapping
    ResponseEntity<List<CategoryReadModel>> readAllTasks(Pageable page) {
        return ResponseEntity.ok(categoryRepository.findAll(page).getContent().stream().map(CategoryReadModel::new).collect(Collectors.toList()));
    }

    @PostMapping
    ResponseEntity<CategoryReadModel> addCategory(@RequestBody @Valid CategoryWriteModel category) {
        CategoryReadModel result = categoryService.createCategory(category);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path("/categories").build().toUri()).body(result);
    }

}
