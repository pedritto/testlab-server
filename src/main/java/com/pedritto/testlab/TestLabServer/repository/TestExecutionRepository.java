package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.model.TestExecution;
import org.springframework.data.repository.CrudRepository;

public interface TestExecutionRepository extends CrudRepository<TestExecution, String> {

}