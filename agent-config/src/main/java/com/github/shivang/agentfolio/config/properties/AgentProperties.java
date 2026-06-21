package com.github.shivang.agentfolio.config.properties;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record AgentProperties(@NotNull @Valid OwnerProperties owner, @NotNull String tone,
		@NotNull @Valid LlmProperties llm, SchedulingProperties scheduling,  MemoryProperties memory) {
}