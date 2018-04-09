package com.pedritto.testlab.TestLabServer.authentication;


import graphql.servlet.GraphQLContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class AuthContext extends GraphQLContext {

    private final String user;

    public AuthContext(String user, Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
        super(request, response);
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
