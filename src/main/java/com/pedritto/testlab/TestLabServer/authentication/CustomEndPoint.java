package com.pedritto.testlab.TestLabServer.authentication;

import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.SimpleGraphQLServlet;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Optional;

@Component
public class CustomEndPoint extends SimpleGraphQLServlet {

    public CustomEndPoint(GraphQLSchema schema) {
        super(schema);
    }

    @Override
    protected GraphQLContext createContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
        String user = request
                .map(req -> req.getHeader("authorization"))
                .orElse(null);
        return new AuthContext(user, request, response);
    }


}
