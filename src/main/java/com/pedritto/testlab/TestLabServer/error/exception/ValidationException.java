package com.pedritto.testlab.TestLabServer.error.exception;

import com.pedritto.testlab.TestLabServer.error.GraphQLErrorType;
import com.pedritto.testlab.TestLabServer.error.TestLabGraphQLException;
import graphql.ErrorType;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationException extends TestLabGraphQLException {

    private static String VALIDATION_ERROR_MESSAGE = "Invalid input";
    private Map<String, Object> extensions = new HashMap<>();

    public ValidationException(Map<String, Object> params) {
        super(VALIDATION_ERROR_MESSAGE);
        extensions.put("type", GraphQLErrorType.VALIDATION);
        extensions.putAll(params);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

}
