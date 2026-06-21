package com.github.shivang.agentfolio.config.properties;

import jakarta.validation.constraints.NotBlank;

public record LlmProperties(
		 @NotBlank  String provider,
		 @NotBlank String apiKey
) {
}