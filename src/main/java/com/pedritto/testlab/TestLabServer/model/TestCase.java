package com.pedritto.testlab.TestLabServer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(collection = "testcase")
@NoArgsConstructor
@Data
public class TestCase {

    @Id
    private String id;

    private String number;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private Category category;

}
