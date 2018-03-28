package com.pedritto.testlab.TestLabServer.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.data.model.TestExecution;
import com.pedritto.testlab.TestLabServer.repository.testExecution.TestExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestExecutionQuery implements GraphQLQueryResolver {

    @Autowired
    private TestExecutionRepository testExecutionRepository;

    public Iterable<TestExecution> findAllTestExecutions() {
        return testExecutionRepository.findAll();
    }

    public TestExecution getTestExecution(String id) {
        return testExecutionRepository.findOne(id);
    }

}
