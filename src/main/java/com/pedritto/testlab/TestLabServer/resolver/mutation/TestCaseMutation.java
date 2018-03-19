package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pedritto.testlab.TestLabServer.model.Category;
import com.pedritto.testlab.TestLabServer.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.CategoryRepository;
import com.pedritto.testlab.TestLabServer.repository.SequenceRepository;
import com.pedritto.testlab.TestLabServer.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseMutation implements GraphQLMutationResolver {

    private String TEST_CASE_PREFIX = "TC";
    private String TEST_CASE_COLLECTION = "testcaseid";

    @Autowired
    private TestCaseRepository testCaseRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SequenceRepository sequenceRepository;

    public TestCase newTestCase(String name, String description, String categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        // @TODO: Exception handling
        if(category == null) {
            return null;
        }
        TestCase testCase = new TestCase();
        String testCaseNumber = this.generateTestCaseNumber();
        testCase.setNumber(testCaseNumber);
        testCase.setName(name);
        testCase.setDescription(description);
        testCase.setCategory(category);
        testCaseRepository.save(testCase);
        return testCase;
    }

    private String generateTestCaseNumber() {
        int sequenceNumber = sequenceRepository.getNextSequence(TEST_CASE_COLLECTION);
        return TEST_CASE_PREFIX + Integer.toString(sequenceNumber);
    }

    public boolean deleteTestCase(String id) {
        TestCase testCase = testCaseRepository.findOne(id);
        if(testCase != null) {
            testCaseRepository.delete(testCase);
            return Boolean.TRUE;
        } else {
            // @TODO: Exception handling
            return Boolean.FALSE;
        }
    }

    public TestCase updateTestCase(String id, String name, String description, String categoryId) {
        TestCase testCase = testCaseRepository.findOne(id);
        Category category = categoryRepository.findOne(categoryId);
        // @TODO: Exception handling
        if(testCase == null || category == null) {
            return null;
        }
        testCase.setName(name);
        testCase.setDescription(description);
        testCase.setCategory(category);
        return testCaseRepository.save(testCase);
    }
}
