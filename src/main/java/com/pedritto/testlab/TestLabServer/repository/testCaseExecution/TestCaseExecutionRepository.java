package com.pedritto.testlab.TestLabServer.repository.testCaseExecution;

import com.pedritto.testlab.TestLabServer.data.model.TestCaseExecution;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestCaseExecutionRepository extends CrudRepository<TestCaseExecution, String>, CustomRepository<TestCaseExecution> {

}

