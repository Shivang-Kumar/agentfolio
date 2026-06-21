package com.github.shivang.agentfolio.config.locator.provider;

import java.nio.file.Path;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class EnvironmentVariableLocationProvider implements AgentConfigurationLocationProvider {

	
    private static final String ENV_VARIABLE = "AGENT_CONFIG_PATH";

	@Override
	public Optional<Path> getLocation() {

		String value = System.getenv(ENV_VARIABLE);

		if (value == null || value.isBlank()) {
			return Optional.empty();
		}

		return Optional.of(Path.of(value));
	}
}