package com.github.shivang.agentfolio.config.locator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import com.github.shivang.agentfolio.config.exception.AgentConfigurationException;
import com.github.shivang.agentfolio.config.locator.provider.AgentConfigurationLocationProvider;


@Component
public class AgentConfigLocationResolver {

	private final List<AgentConfigurationLocationProvider> providers;

	public AgentConfigLocationResolver(List<AgentConfigurationLocationProvider> providers) {
		this.providers = providers;
	}

	public Path resolve() {

		for (AgentConfigurationLocationProvider provider : providers) {

			var location = provider.getLocation();

			if (location.isPresent()) {

				Path configDirectory = location.get();

				if (!Files.exists(configDirectory)) {
					throw new AgentConfigurationException("Configuration directory does not exist: " + configDirectory);
				}

				if (!Files.isDirectory(configDirectory)) {
					throw new AgentConfigurationException("Configuration path is not a directory: " + configDirectory);
				}

				if (!Files.isReadable(configDirectory)) {
					throw new AgentConfigurationException(
							"Configuration directory is not readable: " + configDirectory);
				}

				Path configFile = configDirectory.resolve("agent-config.yaml");

				if (!Files.exists(configFile)) {
					throw new AgentConfigurationException("agent-config.yaml was not found in " + configDirectory);
				}

				return configFile;

			}
		}

		throw new AgentConfigurationException("Unable to locate AgentFolio configuration.");
	}
}
