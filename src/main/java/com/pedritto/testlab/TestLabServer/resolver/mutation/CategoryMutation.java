package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.pedritto.testlab.TestLabServer.data.input.CategoryInput;
import com.pedritto.testlab.TestLabServer.data.model.Category;
import com.pedritto.testlab.TestLabServer.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMutation extends GraphQLBaseMutation<CategoryInput> {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category newCategory(CategoryInput input) {
        validate(input);

        Category category = new Category();
        category.setName(input.getName());
        categoryRepository.save(category);
        return category;
    }

    public boolean deleteCategory(String id) {
        Category category = categoryRepository.findOne(id);
        categoryRepository.delete(category);
        return Boolean.TRUE;
    }
}
