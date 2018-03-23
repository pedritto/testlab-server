package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.pedritto.testlab.TestLabServer.data.input.TestCaseExecutionInput;
import com.pedritto.testlab.TestLabServer.data.model.TestCaseExecution;
import com.pedritto.testlab.TestLabServer.repository.testCaseExecution.TestCaseExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseExecutionMutation extends GraphQLBaseMutation<TestCaseExecutionInput> {

    @Autowired
    private TestCaseExecutionRepository testCaseExecutionRepository;

    public TestCaseExecution updateTestResult(TestCaseExecutionInput input) {
        validate(input);

        TestCaseExecution testCaseExecution = testCaseExecutionRepository.findOne(input.getTestCaseExecutionId());
        testCaseExecution.setTestResult(input.getTestResult());
        testCaseExecutionRepository.save(testCaseExecution);
        return testCaseExecution;
    }
}
