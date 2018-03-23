package com.pedritto.testlab.TestLabServer.repository.testExecution;

import com.pedritto.testlab.TestLabServer.data.model.TestExecution;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestExecutionRepository extends CrudRepository<TestExecution, String>, CustomRepository<TestExecution> {

}
