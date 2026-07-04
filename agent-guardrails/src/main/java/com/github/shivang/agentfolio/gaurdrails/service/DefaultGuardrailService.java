package com.github.shivang.agentfolio.gaurdrails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.shivang.agentfolio.gaurdrails.exception.GuardrailViolationException;
import com.github.shivang.agentfolio.gaurdrails.model.GuardrailResult;
import com.github.shivang.agentfolio.gaurdrails.policy.Guardrail;

@Service
public class DefaultGuardrailService implements GuardrailService {

    private final List<Guardrail> guardrails;

    public DefaultGuardrailService(List<Guardrail> guardrails) {
        this.guardrails = guardrails;
    }

    @Override
    public void validate(String message) {

        for (Guardrail guardrail : guardrails) {

            GuardrailResult result = guardrail.validate(message);

            if (!result.allowed()) {
                throw new GuardrailViolationException(result.reason());
            }
        }
    }
}