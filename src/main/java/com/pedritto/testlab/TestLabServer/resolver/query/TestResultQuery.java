package com.pedritto.testlab.TestLabServer.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.data.model.TestResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TestResultQuery implements GraphQLQueryResolver {

    public Iterable<String> getTestResultValues() {
        List<String> testResultNames = Stream.of(TestResult.values())
                .map(TestResult::name)
                .collect(Collectors.toList());
        return testResultNames;
    }
}
