package com.github.shivang.agentfolio.config.properties;

import jakarta.validation.constraints.NotBlank;

public record OwnerProperties(@NotBlank String name, @NotBlank String role) {
}