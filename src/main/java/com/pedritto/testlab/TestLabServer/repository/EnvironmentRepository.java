package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.model.Environment;
import org.springframework.data.repository.CrudRepository;

public interface EnvironmentRepository extends CrudRepository<Environment, String> {
}
