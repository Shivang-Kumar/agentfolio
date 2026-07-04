package com.github.shivang.agentfolio.gaurdrails.policy;

import org.springframework.stereotype.Component;

import com.github.shivang.agentfolio.gaurdrails.model.GuardrailResult;

@Component
public class EmptyInputGuardrail implements Guardrail {

    @Override
    public GuardrailResult validate(String message) {

        if (message == null || message.isBlank()) {
            return new GuardrailResult(
                    false,
                    "Message cannot be empty."
            );
        }

        return new GuardrailResult(true, null);
    }
}