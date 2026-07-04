package com.github.shivang.agentfolio.gaurdrails.policy;

import com.github.shivang.agentfolio.gaurdrails.model.GuardrailResult;

public interface Guardrail {

	GuardrailResult validate(String message);

}
