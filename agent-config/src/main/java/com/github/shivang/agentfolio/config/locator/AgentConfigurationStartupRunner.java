package com.github.shivang.agentfolio.config.locator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.nio.file.Path;

import com.github.shivang.agentfolio.config.locator.AgentConfigLocationResolver;

@Component
public class AgentConfigurationStartupRunner implements ApplicationRunner {

    private final AgentConfigLocationResolver resolver;

    public AgentConfigurationStartupRunner(
            AgentConfigLocationResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void run(ApplicationArguments args) {

    	  Path configDirectory = resolver.resolve();

          System.out.println("Configuration directory: " + configDirectory);
    }
}