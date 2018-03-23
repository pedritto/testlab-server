package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.data.input.TestCaseFilter;
import com.pedritto.testlab.TestLabServer.data.model.TestCase;

public interface CustomTestCaseRepository {
    Iterable<TestCase> findAll(TestCaseFilter testCaseFilter);
}
