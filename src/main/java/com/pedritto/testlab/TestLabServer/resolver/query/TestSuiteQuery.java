package com.pedritto.testlab.TestLabServer.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.data.model.TestSuite;
import com.pedritto.testlab.TestLabServer.repository.testSuite.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestSuiteQuery implements GraphQLQueryResolver {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    public TestSuite findTestSuite(String id) {
        return testSuiteRepository.findOne(id);
    }

    public  Iterable<TestSuite> findAllTestSuites() {
        return testSuiteRepository.findAll();
    }

}
