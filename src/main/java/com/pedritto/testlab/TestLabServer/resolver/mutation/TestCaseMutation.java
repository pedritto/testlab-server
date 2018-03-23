package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.pedritto.testlab.TestLabServer.data.input.TestCaseInput;
import com.pedritto.testlab.TestLabServer.data.model.Category;
import com.pedritto.testlab.TestLabServer.data.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.category.CategoryRepository;
import com.pedritto.testlab.TestLabServer.repository.sequence.SequenceRepository;
import com.pedritto.testlab.TestLabServer.repository.testCase.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseMutation extends GraphQLBaseMutation<TestCaseInput> {

    private String TEST_CASE_PREFIX = "TC";
    private String TEST_CASE_COLLECTION = "testcaseid";

    @Autowired
    private TestCaseRepository testCaseRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SequenceRepository sequenceRepository;

    public TestCase newTestCase(TestCaseInput input) {

        validate(input);

        Category category = categoryRepository.findOne(input.getCategoryId());

        TestCase testCase = new TestCase();
        String testCaseNumber = this.generateTestCaseNumber();
        testCase.setNumber(testCaseNumber);
        testCase.setName(input.getName());
        testCase.setDescription(input.getDescription());
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
        testCaseRepository.delete(testCase);
        return Boolean.TRUE;
    }

    public TestCase updateTestCase(String id, TestCaseInput input) {

        validate(input);

        TestCase testCase = testCaseRepository.findOne(id);
        Category category = categoryRepository.findOne(input.getCategoryId());
        testCase.setName(input.getName());
        testCase.setDescription(input.getDescription());
        testCase.setCategory(category);
        return testCaseRepository.save(testCase);
    }
}
