package com.pedritto.testlab.TestLabServer.repository.category;

import com.pedritto.testlab.TestLabServer.data.model.Category;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class CategoryRepositoryImpl implements CustomRepository<Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findOne(String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Category.class, id));
        return category;
    }
}
