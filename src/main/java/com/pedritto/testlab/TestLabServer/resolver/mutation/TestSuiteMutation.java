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
        testSuite.setName(input.getName());
        List<TestCase> testCases = input.getTestCaseIds().stream()
                .map(testCaseId -> testCaseRepository.findOne(testCaseId))
                .collect(Collectors.toList());
        testSuite.setTestCases(testCases);
        testSuiteRepository.save(testSuite);
        return testSuite;
    }
}
