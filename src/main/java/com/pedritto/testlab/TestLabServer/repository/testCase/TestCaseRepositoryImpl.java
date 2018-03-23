package com.pedritto.testlab.TestLabServer.repository.testCase;

import com.pedritto.testlab.TestLabServer.data.input.TestCaseFilter;
import com.pedritto.testlab.TestLabServer.data.model.TestCase;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TestCaseRepositoryImpl implements TestCaseRepositoryCustom, CustomRepository<TestCase> {

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

    @Override
    public TestCase findOne(String id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(TestCase.class, id));
        return testCase;
    }

}
