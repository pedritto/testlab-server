package com.pedritto.testlab.TestLabServer.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pedritto.testlab.TestLabServer.model.Category;
import com.pedritto.testlab.TestLabServer.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.CategoryRepository;
import com.pedritto.testlab.TestLabServer.repository.TestCaseRepository;

public class Mutation implements GraphQLMutationResolver {

    private CategoryRepository categoryRepository;
    private TestCaseRepository testCaseRepository;

    public Mutation(CategoryRepository categoryRepository, TestCaseRepository testCaseRepository) {
        this.categoryRepository = categoryRepository;
        this.testCaseRepository = testCaseRepository;
    }

    public Category newCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return category;
    }

    public TestCase newTestCase(String name, String description, Long categoryId) {
        TestCase testCase = new TestCase();
        testCase.setName(name);
        testCase.setDescription(description);
        testCase.setCategory(new Category(categoryId));
        testCaseRepository.save(testCase);
        return testCase;
    }

    public boolean deleteCategory(long id) {
        categoryRepository.delete(id);
        return Boolean.TRUE;
    }

    public boolean deleteTestCase(long id) {
        testCaseRepository.delete(id);
        return Boolean.TRUE;
    }

    public TestCase updateTestCase(long id, String name, String description, Long categoryId) {
        TestCase testCase = testCaseRepository.findOne(id);
        testCase.setName(name);
        testCase.setDescription(description);
        testCase.setCategory(new Category(categoryId));
        return testCaseRepository.save(testCase);
    }
}
