package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pedritto.testlab.TestLabServer.data.model.Environment;
import com.pedritto.testlab.TestLabServer.repository.environment.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentMutation implements GraphQLMutationResolver {

    @Autowired
    private EnvironmentRepository environmentRepository;

    public Environment newEnvironment(String name) {
        Environment environment = new Environment();
        environment.setName(name);
        environmentRepository.save(environment);
        return environment;
    }
}
