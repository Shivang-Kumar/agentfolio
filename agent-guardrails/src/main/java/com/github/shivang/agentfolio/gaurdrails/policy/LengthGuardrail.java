package com.github.shivang.agentfolio.gaurdrails.policy;

import org.springframework.stereotype.Component;

import com.github.shivang.agentfolio.gaurdrails.model.GuardrailResult;

import org.springframework.stereotype.Component;

@Component
public class LengthGuardrail implements Guardrail {

    private static final int MAX_MESSAGE_LENGTH = 4000;

    @Override
    public GuardrailResult validate(String message) {

        if (message != null && message.length() > MAX_MESSAGE_LENGTH) {
            return new GuardrailResult(
                    false,
                    "Message exceeds the maximum allowed length."
            );
        }

        return new GuardrailResult(true, null);
    }
}