package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.model.TestCaseExecution;
import com.pedritto.testlab.TestLabServer.model.TestResult;
import com.pedritto.testlab.TestLabServer.repository.TestCaseExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseExecutionMutation implements GraphQLMutationResolver {

    @Autowired
    private TestCaseExecutionRepository testCaseExecutionRepository;

    public TestCaseExecution updateTestResult(String testCaseExecutionId, TestResult testResult) {
        TestCaseExecution testCaseExecution = testCaseExecutionRepository.findById(testCaseExecutionId)
                .orElseThrow(() -> new EntityNotFoundException(TestCaseExecution.class, testCaseExecutionId));
        testCaseExecution.setTestResult(testResult);
        testCaseExecutionRepository.save(testCaseExecution);
        return testCaseExecution;
    }
}
