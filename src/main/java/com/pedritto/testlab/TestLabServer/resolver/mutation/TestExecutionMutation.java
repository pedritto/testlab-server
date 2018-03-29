package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.pedritto.testlab.TestLabServer.data.input.TestExecutionInput;
import com.pedritto.testlab.TestLabServer.data.model.*;
import com.pedritto.testlab.TestLabServer.repository.environment.EnvironmentRepository;
import com.pedritto.testlab.TestLabServer.repository.testCaseExecution.TestCaseExecutionRepository;
import com.pedritto.testlab.TestLabServer.repository.testExecution.TestExecutionRepository;
import com.pedritto.testlab.TestLabServer.repository.testSuite.TestSuiteRepository;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestExecutionMutation extends GraphQLBaseMutation<TestExecutionInput> {

    @Autowired
    private TestExecutionRepository testExecutionRepository;
    @Autowired
    private TestSuiteRepository testSuiteRepository;
    @Autowired
    private EnvironmentRepository environmentRepository;
    @Autowired
    private TestCaseExecutionRepository testCaseExecutionRepository;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public TestExecution newTestExecution(TestExecutionInput input) {
        validate(input);

        TestSuite testSuite = testSuiteRepository.findOne(input.getTestSuiteId());
        Environment environment = environmentRepository.findOne(input.getEnvironmentId());

        TestExecution testExecution = new TestExecution();
        testExecution.setName(testSuite.getName());
        testExecution.setEnvironment(environment);
        List<TestCaseExecution> testCaseExecutions = testSuite.getTestCases().stream()
                .map(testCaseId -> this.prepareTestCaseExecution(testCaseId))
                .collect(Collectors.toList());
        testExecution.setTestCaseExecutions(testCaseExecutions);
        testExecution.setCreated(LocalDateTime.now());
        testExecutionRepository.save(testExecution);
        return testExecution;
    }

    private TestCaseExecution prepareTestCaseExecution(TestCase testCase) {
        TestCaseExecution testCaseExecution = dozerBeanMapper.map(testCase, TestCaseExecution.class);
        testCaseExecution.setTestResult(TestResult.WAITING);
        testCaseExecution.setLastModified(LocalDateTime.now());
        testCaseExecutionRepository.save(testCaseExecution);
        return testCaseExecution;
    }
}
