package com.pedritto.testlab.TestLabServer.repository.environment;

import com.pedritto.testlab.TestLabServer.data.model.Environment;
import com.pedritto.testlab.TestLabServer.error.exception.EntityNotFoundException;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentRepositoryImpl implements CustomRepository<Environment> {

    @Autowired
    private EnvironmentRepository environmentRepository;

    @Override
    public Environment findOne(String id) {
        Environment environment = environmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Environment.class, id));
        return environment;
    }
}
