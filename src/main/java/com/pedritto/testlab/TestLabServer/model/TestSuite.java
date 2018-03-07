package com.pedritto.testlab.TestLabServer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "testsuite")
@NoArgsConstructor
@Data
public class TestSuite {

    @Id
    private String id;

    private String name;

    @DBRef
    private List<TestCase> testCases;
}
