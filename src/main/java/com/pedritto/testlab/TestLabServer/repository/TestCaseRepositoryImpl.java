package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.data.input.TestCaseFilter;
import com.pedritto.testlab.TestLabServer.data.model.TestCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestCaseRepositoryImpl implements CustomTestCaseRepository {

    @Autowired
    private TestCaseRepository testCaseRepository;

    @Override
    public List<TestCase> findAll(TestCaseFilter filter) {
        Iterable<TestCase> testCases = testCaseRepository.findAll();

        List<TestCase> filteredTestCases = StreamSupport
                .stream(testCases.spliterator(), false)
                .filter(testCase -> filter.getCategoryId() == "" || filter.getCategoryId().equals(testCase.getCategory().getId()))
                .filter(testCase -> filter.getSearchText() == "" ||
                        testCase.getNumber().contains(filter.getSearchText()) ||
                        testCase.getName().contains(filter.getSearchText()) ||
                        testCase.getDescription().contains(filter.getSearchText()))
                .collect(Collectors.toList());

        return filteredTestCases;
    }
}
