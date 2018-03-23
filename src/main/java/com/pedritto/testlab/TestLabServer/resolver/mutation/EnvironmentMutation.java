package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.pedritto.testlab.TestLabServer.data.input.EnvironmentInput;
import com.pedritto.testlab.TestLabServer.data.model.Environment;
import com.pedritto.testlab.TestLabServer.repository.environment.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentMutation extends GraphQLBaseMutation<EnvironmentInput> {

    @Autowired
    private EnvironmentRepository environmentRepository;

    public Environment newEnvironment(EnvironmentInput input) {
        validate(input);

        Environment environment = new Environment();
        environment.setName(input.getName());
        environmentRepository.save(environment);
        return environment;
    }
}
