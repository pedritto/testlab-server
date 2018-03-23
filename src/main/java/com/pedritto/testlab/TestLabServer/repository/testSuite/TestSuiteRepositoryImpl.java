package com.pedritto.testlab.TestLabServer.repository.testSuite;

import com.pedritto.testlab.TestLabServer.data.model.TestSuite;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestSuiteRepositoryImpl implements CustomRepository<TestSuite> {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @Override
    public TestSuite findOne(String id) {
        TestSuite testCaseExecution = testSuiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(TestSuite.class, id));
        return testCaseExecution;
    }
}
