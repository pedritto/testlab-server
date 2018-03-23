package com.pedritto.testlab.TestLabServer.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "testexecution")
@NoArgsConstructor
@Data
public class TestExecution {

    @Id
    private String id;

    private String name;

    private TestSuite testSuite;

    private Environment environment;

    @DBRef
    private List<TestCaseExecution> testCaseExecutions;

}
