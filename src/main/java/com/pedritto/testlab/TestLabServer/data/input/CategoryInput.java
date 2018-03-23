package com.pedritto.testlab.TestLabServer.data.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class CategoryInput {

    @NotEmpty
    private String name;
}
