package com.pedritto.testlab.TestLabServer.repository.testCase;

import com.pedritto.testlab.TestLabServer.data.model.TestCase;
import org.springframework.data.repository.CrudRepository;

public interface TestCaseRepository extends CrudRepository<TestCase, String>, TestCaseRepositoryCustom {

}
