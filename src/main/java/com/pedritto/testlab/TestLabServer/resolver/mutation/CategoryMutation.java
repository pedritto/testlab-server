package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.model.Category;
import com.pedritto.testlab.TestLabServer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMutation implements GraphQLMutationResolver {

    private String NOT_FOUND_ERROR_MESSAGE = "Category was not found.";

    @Autowired
    private CategoryRepository categoryRepository;

    public Category newCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return category;
    }

    public boolean deleteCategory(String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Category.class, id));
        categoryRepository.delete(category);
        return Boolean.TRUE;
    }
}
