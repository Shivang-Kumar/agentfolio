package com.github.shivang.agentfolio.config.locator;

import java.nio.file.Path;
import java.util.Optional;

public interface AgentConfigurationLocationProvider {
		
	Optional<Path> getLocation();
}
