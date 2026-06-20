package com.github.shivang.agentfolio.config.configurations;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.github.shivang.agentfolio.config.properties.AgentProperties;

@Configuration
@EnableConfigurationProperties(AgentProperties.class)
public class AgentConfiguration {

}