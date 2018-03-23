package com.pedritto.testlab.TestLabServer.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pedritto.testlab.TestLabServer.data.model.Environment;
import com.pedritto.testlab.TestLabServer.repository.environment.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentQuery implements GraphQLQueryResolver {

    @Autowired
    private EnvironmentRepository environmentRepository;

    public  Iterable<Environment> findAllEnvironments() {
        return environmentRepository.findAll();
    }
}
