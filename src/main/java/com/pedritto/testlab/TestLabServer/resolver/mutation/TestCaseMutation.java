package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pedritto.testlab.TestLabServer.model.Category;
import com.pedritto.testlab.TestLabServer.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.CategoryRepository;
import com.pedritto.testlab.TestLabServer.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseMutation implements GraphQLMutationResolver {

    @Autowired
    private TestCaseRepository testCaseRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public TestCase newTestCase(String name, String description, String categoryId) {
        TestCase testCase = new TestCase();
        testCase.setName(name);
        testCase.setDescription(description);
        Category category = categoryRepository.findOne(categoryId);
        testCase.setCategory(category);
        testCaseRepository.save(testCase);
        return testCase;
    }

    public boolean deleteTestCase(String id) {
        testCaseRepository.delete(id);
        return Boolean.TRUE;
    }

    public TestCase updateTestCase(String id, String name, String description, String categoryId) {
        TestCase testCase = testCaseRepository.findOne(id);
        testCase.setName(name);
        testCase.setDescription(description);
        Category category = categoryRepository.findOne(categoryId);
        testCase.setCategory(category);
        return testCaseRepository.save(testCase);
    }
}
