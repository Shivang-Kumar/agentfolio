package com.github.shivang.agentfolio.config.exception;

import java.util.List;

public class AgentConfigurationException extends RuntimeException {

	private final List<String> errors;

	public AgentConfigurationException(String message) {
		super(message);
		this.errors = List.of();
	}

	public AgentConfigurationException(String message, List<String> errors) {
		super(message);
		this.errors = List.copyOf(errors);
	}

	public List<String> getErrors() {
		return errors;
	}

}
