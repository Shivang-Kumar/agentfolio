package com.github.shivang.agentfolio.core.prompt;

import org.springframework.stereotype.Service;

import com.github.shivang.agentfolio.config.properties.AgentProperties;
import com.github.shivang.agentfolio.knowledge.provider.KnowledgeProvider;

public class  PromptServiceImplementation {
	@Service
	public class PromptServiceImpl implements PromptService {

	    private final AgentProperties agentProperties;
	    private final KnowledgeProvider knowledgeProvider;
	    
	    public PromptServiceImpl(AgentProperties agentProperties,KnowledgeProvider knowledgeProvider) {
	     this.agentProperties=agentProperties;
	     this.knowledgeProvider=knowledgeProvider;
	    }

	    @Override
	    public String buildPrompt(String userMessage) {
	    	  return String.format(
	                  SystemPromptTemplate.SYSTEM_PROMPT,
	                  agentProperties.owner(),
	                  knowledgeProvider.provideKnowledge(),
	                  userMessage
	          );
	    }
}
}