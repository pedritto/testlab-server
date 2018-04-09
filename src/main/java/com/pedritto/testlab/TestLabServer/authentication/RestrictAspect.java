package com.pedritto.testlab.TestLabServer.authentication;

import graphql.schema.DataFetchingEnvironment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestrictAspect {
    @Before("@annotation(com.pedritto.testlab.TestLabServer.authentication.Restrict) && execution(public * *(..))")
    public void restrict(final JoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        for (int argIndex = 0; argIndex < args.length; argIndex++) {
            if (args[argIndex] instanceof DataFetchingEnvironment) {
                DataFetchingEnvironment env = (DataFetchingEnvironment)args[argIndex];
                AuthContext context = env.getContext();
                System.out.println(context.getUser());
            }
        }
    }
}
