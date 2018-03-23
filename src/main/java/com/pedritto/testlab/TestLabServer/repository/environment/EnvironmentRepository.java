package com.pedritto.testlab.TestLabServer.repository.environment;

import com.pedritto.testlab.TestLabServer.data.model.Environment;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.data.repository.CrudRepository;

public interface EnvironmentRepository extends CrudRepository<Environment, String>, CustomRepository<Environment> {
}
