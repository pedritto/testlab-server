package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.data.model.TestCase;
import com.pedritto.testlab.TestLabServer.data.model.TestSuite;
import com.pedritto.testlab.TestLabServer.repository.TestCaseRepository;
import com.pedritto.testlab.TestLabServer.repository.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestSuiteMutation implements GraphQLMutationResolver {

    @Autowired
    private TestSuiteRepository testSuiteRepository;
    @Autowired
    private TestCaseRepository testCaseRepository;

    public TestSuite newTestSuite(String name, List<String> testCaseIds) {
        TestSuite testSuite = new TestSuite();
        testSuite.setName(name);
        List<TestCase> testCases = testCaseIds.stream()
                .map(testCaseId -> testCaseRepository.findById(testCaseId)
                        .orElseThrow(() -> new EntityNotFoundException(TestCase.class, testCaseId)))
                .collect(Collectors.toList());
        testSuite.setTestCases(testCases);
        testSuiteRepository.save(testSuite);
        return testSuite;
    }
}
