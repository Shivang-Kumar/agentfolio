package com.github.shivang.agentfolio.gaurdrails.model;

public record GuardrailResult(
        boolean allowed,
        String reason
) {}