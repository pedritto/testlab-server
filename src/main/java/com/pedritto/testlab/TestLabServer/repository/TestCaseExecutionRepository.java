package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.data.model.TestCaseExecution;
import org.springframework.data.repository.CrudRepository;

public interface TestCaseExecutionRepository extends CrudRepository<TestCaseExecution, String> {

}

