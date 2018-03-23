package com.pedritto.testlab.TestLabServer.repository.testSuite;

import com.pedritto.testlab.TestLabServer.data.model.TestSuite;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestSuiteRepository  extends CrudRepository<TestSuite, String>, CustomRepository<TestSuite> {
}
