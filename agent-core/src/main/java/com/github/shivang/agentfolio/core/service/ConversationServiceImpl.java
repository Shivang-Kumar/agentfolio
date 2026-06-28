package com.github.shivang.agentfolio.core.service;


import org.springframework.stereotype.Service;

import com.github.shivang.agentfolio.core.prompt.PromptService;

import reactor.core.publisher.Flux;

@Service
public class ConversationServiceImpl implements ConversationService {
	
	private final PromptService promptService;
	
	public ConversationServiceImpl(PromptService promptService)
	{
		this.promptService=promptService;
	}

    @Override
    public Flux<String> chat(String sessionId, String message) {
    	
    	  String prompt = promptService.buildPrompt(message);

          // Phase 3:
          // return chatClient.prompt(prompt)
          //                  .stream()
          //                  .content();
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
