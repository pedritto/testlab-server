package com.pedritto.testlab.TestLabServer.error;

import graphql.GraphQLError;

public abstract class TestLabGraphQLException extends RuntimeException implements GraphQLError {

    public TestLabGraphQLException(String message) {
        super(message);
    }
}
