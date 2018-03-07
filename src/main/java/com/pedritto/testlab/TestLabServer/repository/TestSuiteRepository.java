package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.model.TestSuite;
import org.springframework.data.repository.CrudRepository;

public interface TestSuiteRepository  extends CrudRepository<TestSuite, String> {
}
