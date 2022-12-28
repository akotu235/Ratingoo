package io.github.akotu235.Ratingoo.adapter;


import io.github.akotu235.Ratingoo.model.Category;
import io.github.akotu235.Ratingoo.model.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlCategoryRepository extends CategoryRepository, JpaRepository<Category, Integer> {

}
