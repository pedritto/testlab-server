package com.pedritto.testlab.TestLabServer.data.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TestCaseFilter {
    private String searchText;
    private String categoryId;
}
