package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.model.*;
import com.pedritto.testlab.TestLabServer.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestExecutionMutation implements GraphQLMutationResolver {

    @Autowired
    private TestExecutionRepository testExecutionRepository;
    @Autowired
    private TestSuiteRepository testSuiteRepository;
    @Autowired
    private EnvironmentRepository environmentRepository;
    @Autowired
    private TestCaseExecutionRepository testCaseExecutionRepository;

    public TestExecution newTestExecution(String name, String testSuiteId, String environmentId) {
        TestSuite testSuite = testSuiteRepository.findById(testSuiteId)
                .orElseThrow(() -> new EntityNotFoundException(TestSuite.class, testSuiteId));

        Environment environment = environmentRepository.findById(environmentId)
                .orElseThrow(()-> new EntityNotFoundException(Environment.class, environmentId));

        TestExecution testExecution = new TestExecution();
        testExecution.setName(name);
        testExecution.setTestSuite(testSuite);
        testExecution.setEnvironment(environment);
        List<TestCaseExecution> testCaseExecutions = testSuite.getTestCases().stream()
                .map(testCaseId -> this.prepareTestCaseExecution(testCaseId))
                .collect(Collectors.toList());
        testExecution.setTestCaseExecutions(testCaseExecutions);
        testExecutionRepository.save(testExecution);
        return testExecution;
    }

    private TestCaseExecution prepareTestCaseExecution(TestCase testCase) {
        TestCaseExecution testCaseExecution = new TestCaseExecution();
        testCaseExecution.setTestCase(testCase);
        testCaseExecution.setTestResult(TestResult.WAITING);
        testCaseExecutionRepository.save(testCaseExecution);
        return testCaseExecution;
    }
}
