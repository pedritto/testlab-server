package com.pedritto.testlab.TestLabServer.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counters")
@NoArgsConstructor
@Data
public class Counter {

    @Id
    private String id;
    private int sequence;
}
