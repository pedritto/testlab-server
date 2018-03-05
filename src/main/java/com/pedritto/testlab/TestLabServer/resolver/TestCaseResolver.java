package com.pedritto.testlab.TestLabServer.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pedritto.testlab.TestLabServer.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.TestCaseRepository;

public class TestCaseResolver implements GraphQLResolver<TestCase> {

    private TestCaseRepository testCaseRepository;

    public TestCaseResolver(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }
}
