package com.github.shivang.agentfolio.gaurdrails.exception;

public class GuardrailViolationException extends RuntimeException {

    public GuardrailViolationException(String message) {
        super(message);
    }

    public GuardrailViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}