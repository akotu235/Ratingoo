package io.github.akotu235.Ratingoo.logic;

import io.github.akotu235.Ratingoo.model.Category;
import io.github.akotu235.Ratingoo.model.CategoryRepository;
import io.github.akotu235.Ratingoo.model.projection.CategoryReadModel;
import io.github.akotu235.Ratingoo.model.projection.CategoryWriteModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryReadModel createCategory(CategoryWriteModel source) {
        Category result = categoryRepository.findByName(source.getName()).orElseGet(()->categoryRepository.save(source.toCategory(source.getName())));
        return new CategoryReadModel(result);
    }

    public Optional<Category> getCategory(String name){
        return categoryRepository.findByName(name);
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.findById(id);
    }
}
