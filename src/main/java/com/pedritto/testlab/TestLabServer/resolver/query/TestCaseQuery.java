package com.pedritto.testlab.TestLabServer.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.authentication.AuthContext;
import com.pedritto.testlab.TestLabServer.authentication.Restrict;
import com.pedritto.testlab.TestLabServer.data.input.TestCaseFilter;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.data.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.testCase.TestCaseRepository;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseQuery implements GraphQLQueryResolver {

    @Autowired
    private TestCaseRepository testCaseRepository;

    @Restrict
    public Iterable<TestCase> findAllTestCases(DataFetchingEnvironment env) {
        return testCaseRepository.findAll();
    }

    @Restrict
    public TestCase findTestCase(String id, DataFetchingEnvironment env) {
        return testCaseRepository.findOne(id);
    }

    @Restrict
    public Iterable<TestCase> filterTestCases(TestCaseFilter testCaseFilter, DataFetchingEnvironment env) {
        return testCaseRepository.findAll(testCaseFilter);
    }

}
