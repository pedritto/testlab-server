package com.pedritto.testlab.TestLabServer.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.model.TestSuite;
import com.pedritto.testlab.TestLabServer.repository.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestSuiteQuery implements GraphQLQueryResolver {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    public  Iterable<TestSuite> findAllTestSuites() {
        return testSuiteRepository.findAll();
    }

}