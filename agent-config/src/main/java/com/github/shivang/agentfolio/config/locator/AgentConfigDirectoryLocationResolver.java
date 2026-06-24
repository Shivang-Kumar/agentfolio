package com.github.shivang.agentfolio.config.locator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import com.github.shivang.agentfolio.config.exception.AgentConfigurationException;
import com.github.shivang.agentfolio.config.locator.provider.AgentConfigurationDirectoryLocationProvider;


@Component
public class AgentConfigDirectoryLocationResolver {

	private final List<AgentConfigurationDirectoryLocationProvider> providers;

	public AgentConfigDirectoryLocationResolver(List<AgentConfigurationDirectoryLocationProvider> providers) {
		this.providers = providers;
	}

	public Path resolveConfigDirectoryLocation() {

		for (AgentConfigurationDirectoryLocationProvider provider : providers) {

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

				return configDirectory;

			}
		}

		throw new AgentConfigurationException("Unable to locate AgentFolio configuration.");
	}
}
