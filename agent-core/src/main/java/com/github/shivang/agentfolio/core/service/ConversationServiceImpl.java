package com.github.shivang.agentfolio.core.service;


import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.stereotype.Service;

import com.github.shivang.agentfolio.core.prompt.PromptService;
import com.github.shivang.agentfolio.service.ConversationMemoryService;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;

@Service
public class ConversationServiceImpl implements ConversationService {
	
	private final PromptService promptService;
	private final ChatClient chatClient;
	private final ConversationMemoryService conversationMemoryService;
	public ConversationServiceImpl(PromptService promptService,ChatClient chatClient,ConversationMemoryService conversationMemoryService)
	{
		this.promptService=promptService;
		this.chatClient=chatClient;
		this.conversationMemoryService=conversationMemoryService;
	}

	
    @Override
    public Flux<String> chat(String sessionId, String message) {
    	
    	
    	  conversationMemoryService.addMessage(sessionId,new UserMessage(message));
    	  List<Message> history = conversationMemoryService.getConversation(sessionId);
    	  String prompt = promptService.buildPrompt(history,message);
    	  return chatClient.prompt(prompt)
    	            .stream()                           // 1. Keep streaming to keep Netty happy (non-blocking)
    	            .content()                          // 2. Returns Flux<String>
    	            .collectList()                      // 3. Collects all chunks into a Mono<List<String>> asynchronously
    	            .map(list -> String.join("", list)) // 4. Joins the entire list into one single String
    	            .flux();        
    }
}
