package com.pedritto.testlab.TestLabServer.repository.testExecution;

import com.pedritto.testlab.TestLabServer.data.model.TestExecution;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import com.pedritto.testlab.TestLabServer.repository.testCaseExecution.TestCaseExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestExecutionRepositoryImpl implements CustomRepository<TestExecution> {

    @Autowired
    private TestExecutionRepository testExecutionRepository;

    @Override
    public TestExecution findOne(String id) {
        TestExecution testCaseExecution = testExecutionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(TestExecution.class, id));
        return testCaseExecution;
    }
}
