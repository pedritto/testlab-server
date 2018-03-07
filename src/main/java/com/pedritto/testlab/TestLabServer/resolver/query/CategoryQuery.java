package com.pedritto.testlab.TestLabServer.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.model.Category;
import com.pedritto.testlab.TestLabServer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryQuery implements GraphQLQueryResolver {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
