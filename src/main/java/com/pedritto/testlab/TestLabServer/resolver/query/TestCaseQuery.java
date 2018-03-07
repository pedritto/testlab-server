package com.pedritto.testlab.TestLabServer.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseQuery implements GraphQLQueryResolver {

    @Autowired
    private TestCaseRepository testCaseRepository;

    public Iterable<TestCase> findAllTestCases() {
        return testCaseRepository.findAll();
    }

}