package com.pedritto.testlab.TestLabServer.data.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class TestCaseInput {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private String categoryId;
}
