package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.model.TestCase;
import org.springframework.data.repository.CrudRepository;

public interface TestCaseRepository extends CrudRepository<TestCase, Long> {

}
