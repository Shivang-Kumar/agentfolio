package com.github.shivang.agentfolio.api;

public record ErrorResponse(
        String code,
        String message
) {
}