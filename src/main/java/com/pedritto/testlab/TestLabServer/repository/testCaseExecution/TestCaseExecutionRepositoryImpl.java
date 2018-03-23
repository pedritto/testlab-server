package com.pedritto.testlab.TestLabServer.repository.testCaseExecution;

import com.pedritto.testlab.TestLabServer.data.model.TestCaseExecution;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseExecutionRepositoryImpl implements CustomRepository<TestCaseExecution> {

    @Autowired
    private TestCaseExecutionRepository testCaseExecutionRepository;


    @Override
    public TestCaseExecution findOne(String id) {
        TestCaseExecution testCaseExecution = testCaseExecutionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(TestCaseExecution.class, id));
        return testCaseExecution;
    }
}
