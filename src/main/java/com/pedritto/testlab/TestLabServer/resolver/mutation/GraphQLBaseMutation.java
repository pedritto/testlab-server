package com.pedritto.testlab.TestLabServer.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pedritto.testlab.TestLabServer.resolver.validation.ValidationResolver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GraphQLBaseMutation<T> implements GraphQLMutationResolver {

    @Autowired
    private ValidationResolver validationResolver;

    protected void validate(T entity) {
        validationResolver.processValidationResult(entity);
    }

}
