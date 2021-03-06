package com.pedritto.testlab.TestLabServer.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.data.input.TestCaseFilter;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.data.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.testCase.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseQuery implements GraphQLQueryResolver {

    @Autowired
    private TestCaseRepository testCaseRepository;

    public Iterable<TestCase> findAllTestCases() {
        return testCaseRepository.findAll();
    }

    public TestCase findTestCase(String id) {
        return testCaseRepository.findOne(id);
    }

    public Iterable<TestCase> filterTestCases(TestCaseFilter testCaseFilter) {
        return testCaseRepository.findAll(testCaseFilter);
    }

}
