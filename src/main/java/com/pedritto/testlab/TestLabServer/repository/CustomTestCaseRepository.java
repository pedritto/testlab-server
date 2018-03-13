package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.data.TestCaseFilter;
import com.pedritto.testlab.TestLabServer.model.TestCase;

public interface CustomTestCaseRepository {
    Iterable<TestCase> findAll(TestCaseFilter testCaseFilter);
}
