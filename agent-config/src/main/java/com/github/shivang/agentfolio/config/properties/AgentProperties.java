package com.github.shivang.agentfolio.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "agent")
public record AgentProperties(
        OwnerProperties owner,
        String tone,
        LlmProperties llm,
        SchedulingProperties scheduling,
        MemoryProperties memory
) {
}