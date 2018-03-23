package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.data.model.Environment;
import org.springframework.data.repository.CrudRepository;

public interface EnvironmentRepository extends CrudRepository<Environment, String> {
}
