package com.pedritto.testlab.TestLabServer.data.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
public class TestSuiteInput {

    @NotEmpty
    String name;

    @NotEmpty
    List<@NotEmpty String> testCaseIds;
}
