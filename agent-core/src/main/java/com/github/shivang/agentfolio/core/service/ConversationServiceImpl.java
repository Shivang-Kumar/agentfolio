package com.github.shivang.agentfolio.core.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.github.shivang.agentfolio.core.prompt.PromptService;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;

@Service
public class ConversationServiceImpl implements ConversationService {
	
	private final PromptService promptService;
	private final ChatClient chatClient;

	public ConversationServiceImpl(PromptService promptService,ChatClient chatClient)
	{
		this.promptService=promptService;
		this.chatClient=chatClient;
	}

	
    @Override
    public Flux<String> chat(String sessionId, String message) {
    	
    	  String prompt = promptService.buildPrompt(message);
    	  return chatClient.prompt(prompt).stream().content();
    }
}
