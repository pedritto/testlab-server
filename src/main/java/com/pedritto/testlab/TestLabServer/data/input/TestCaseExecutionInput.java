package com.pedritto.testlab.TestLabServer.data.input;

import com.pedritto.testlab.TestLabServer.data.model.TestResult;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class TestCaseExecutionInput {

    @NotEmpty
    String testCaseExecutionId;

    TestResult testResult;
}
