package com.github.shivang.agentfolio.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.shivang.agentfolio.gaurdrails.exception.GuardrailViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GuardrailViolationException.class)
    public ResponseEntity<ErrorResponse> handleGuardrailViolation(
            GuardrailViolationException ex) {

        ErrorResponse response = new ErrorResponse(
                "GUARDRAIL_VIOLATION",
                ex.getMessage()
        );

        return ResponseEntity.badRequest().body(response);
    }
}