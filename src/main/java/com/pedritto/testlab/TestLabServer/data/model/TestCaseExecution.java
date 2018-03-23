package com.pedritto.testlab.TestLabServer.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testcaseexecution")
@NoArgsConstructor
@Data
public class TestCaseExecution {

    @Id
    private String id;

    private TestCase testCase;

    private TestResult testResult;

}
