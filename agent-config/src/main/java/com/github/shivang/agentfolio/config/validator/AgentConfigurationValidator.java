package com.github.shivang.agentfolio.config.validator;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.github.shivang.agentfolio.config.exception.AgentConfigurationException;
import com.github.shivang.agentfolio.config.properties.AgentProperties;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Component
public class AgentConfigurationValidator {

    private final Validator validator;
    private static final Logger log =
            LoggerFactory.getLogger(AgentConfigurationValidator.class);

    public AgentConfigurationValidator(Validator validator) {
        this.validator = validator;
    }

    public void validate(AgentProperties properties) {

        Set<ConstraintViolation<AgentProperties>> violations =
                validator.validate(properties);

        if (!violations.isEmpty()) {

            List<String> errors = violations.stream()
                    .map(v -> v.getPropertyPath() + " " + v.getMessage())
                    .toList();

            log.error("Configuration validation failed:");


            throw new AgentConfigurationException("Please set up the configuration properties correctly.",errors);
        }

       return;
    }
}