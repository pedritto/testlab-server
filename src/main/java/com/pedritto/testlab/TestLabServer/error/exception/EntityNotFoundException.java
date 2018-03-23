package com.pedritto.testlab.TestLabServer.error.exception;

import com.pedritto.testlab.TestLabServer.error.GraphQLErrorType;
import com.pedritto.testlab.TestLabServer.error.TestLabGraphQLException;
import graphql.ErrorType;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityNotFoundException extends TestLabGraphQLException {

    private static String NOT_FOUND_ERROR_MESSAGE = " was not found";
    private Map<String, Object> extensions = new HashMap<>();

    public EntityNotFoundException(Class clazz, String id) {
        super(clazz.getSimpleName() + NOT_FOUND_ERROR_MESSAGE);
        extensions.put("type", GraphQLErrorType.VALIDATION);
        extensions.put("id", id);
        extensions.put("model", clazz.getSimpleName());
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
        return ErrorType.DataFetchingException;
    }

}
