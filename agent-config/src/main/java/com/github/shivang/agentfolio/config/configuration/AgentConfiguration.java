package com.github.shivang.agentfolio.config.configuration;

import java.nio.file.Path;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.shivang.agentfolio.config.locator.AgentConfigDirectoryLocationResolver;
import com.github.shivang.agentfolio.config.properties.AgentProperties;
import com.github.shivang.agentfolio.config.reader.AgentConfigurationReader;
import com.github.shivang.agentfolio.config.validator.AgentConfigurationValidator;

@Configuration
public class AgentConfiguration {

	@Bean
	public AgentProperties agentProperties(AgentConfigDirectoryLocationResolver configDirectoryResolver, AgentConfigurationReader reader, AgentConfigurationValidator validator) {
		Path configDirectory=configDirectoryResolver.resolve();
		Path configFile =configDirectory.resolve("agent-config.yaml");
		AgentProperties agentProperties=reader.read(configFile);
		validator.validate(agentProperties);
		return agentProperties;
	}

}
