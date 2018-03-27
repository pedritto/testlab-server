package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.pedritto.testlab.TestLabServer.data.input.TestSuiteInput;
import com.pedritto.testlab.TestLabServer.data.model.TestCase;
import com.pedritto.testlab.TestLabServer.data.model.TestSuite;
import com.pedritto.testlab.TestLabServer.repository.testCase.TestCaseRepository;
import com.pedritto.testlab.TestLabServer.repository.testSuite.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestSuiteMutation extends GraphQLBaseMutation<TestSuiteInput>{

    @Autowired
    private TestSuiteRepository testSuiteRepository;
    @Autowired
    private TestCaseRepository testCaseRepository;

    public TestSuite newTestSuite(TestSuiteInput input) {
        validate(input);
        TestSuite testSuite = new TestSuite();
        setProperties(testSuite, input);
        testSuiteRepository.save(testSuite);
        return testSuite;
    }

    public TestSuite updateTestSuite(String id, TestSuiteInput input) {
        validate(input);
        TestSuite testSuite = testSuiteRepository.findOne(id);
        setProperties(testSuite, input);
        testSuiteRepository.save(testSuite);
        return testSuite;
    }

    public Boolean deleteTestSuite(String id) {
        TestSuite testSuite = testSuiteRepository.findOne(id);
        testSuiteRepository.delete(testSuite);
        return Boolean.TRUE;
    }

    private void setProperties(TestSuite testSuite, TestSuiteInput input) {
        testSuite.setName(input.getName());
        List<TestCase> testCases = input.getTestCaseIds().stream()
                .map(testCaseId -> testCaseRepository.findOne(testCaseId))
                .collect(Collectors.toList());
        testSuite.setTestCases(testCases);
    }
}
