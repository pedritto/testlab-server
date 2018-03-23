package com.pedritto.testlab.TestLabServer.resolver.validation;

import com.pedritto.testlab.TestLabServer.error.exception.ValidationException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ValidationResolver<T> {

    private static Validator validator;

    public ValidationResolver() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public void processValidationResult(T entity) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (!constraintViolations.isEmpty()) {
            Map<String, Object> violations = constraintViolations.stream()
                    .collect(
                            Collectors.toMap(
                                    violation -> violation.getPropertyPath().toString(),
                                    violation -> violation.getMessage()
                            )
                    );
            throw new ValidationException(violations);
        }
    }
}
