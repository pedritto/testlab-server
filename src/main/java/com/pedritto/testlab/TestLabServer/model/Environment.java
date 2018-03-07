package com.pedritto.testlab.TestLabServer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "environment")
@NoArgsConstructor
@Data
public class Environment {

    @Id
    private String id;

    private String name;
}
