package com.pedritto.testlab.TestLabServer.repository.testCase;

import com.pedritto.testlab.TestLabServer.data.input.TestCaseFilter;
import com.pedritto.testlab.TestLabServer.data.model.TestCase;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;

public interface TestCaseRepositoryCustom extends CustomRepository<TestCase> {

    Iterable<TestCase> findAll(TestCaseFilter testCaseFilter);

    TestCase findOne(String id);
}
