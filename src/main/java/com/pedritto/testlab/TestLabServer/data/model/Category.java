package com.pedritto.testlab.TestLabServer.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
@NoArgsConstructor
@Data
public class Category {

    @Id
    private String id;

    private String name;

    public Category(String id) {
        this.id = id;
    }
}
