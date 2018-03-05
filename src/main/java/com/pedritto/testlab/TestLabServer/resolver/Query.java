package com.pedritto.testlab.TestLabServer.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.model.Category;
import com.pedritto.testlab.TestLabServer.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.CategoryRepository;
import com.pedritto.testlab.TestLabServer.repository.TestCaseRepository;

public class Query implements GraphQLQueryResolver {

    private CategoryRepository categoryRepository;
    private TestCaseRepository testCaseRepository;

    public Query(CategoryRepository categoryRepository, TestCaseRepository testCaseRepository) {
        this.categoryRepository = categoryRepository;
        this.testCaseRepository = testCaseRepository;
    }

    public Iterable<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Iterable<TestCase> findAllTestCases() {
        return testCaseRepository.findAll();
    }

}
