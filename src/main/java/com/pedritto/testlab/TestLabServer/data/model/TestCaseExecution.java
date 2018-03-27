package com.pedritto.testlab.TestLabServer.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "testcaseexecution")
@NoArgsConstructor
@Data
public class TestCaseExecution extends TestCase{

    private TestResult testResult;

    protected LocalDateTime lastModified;
}
