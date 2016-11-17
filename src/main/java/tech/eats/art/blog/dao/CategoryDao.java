package tech.eats.art.blog.dao;

import tech.eats.art.blog.model.Category;

import java.util.List;

/**
 * Created by John on 11/17/16.
 */
public interface CategoryDao {
    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void delete(Category category);
}
