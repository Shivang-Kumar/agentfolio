package com.github.shivang.agentfolio.service;

import java.util.List;

import org.springframework.ai.chat.messages.Message;

public interface ConversationMemoryService {
	
	List<Message> getConversation(String sessionId);

	void addMessage(String sessionId, Message message);

	void clearConversation(String sessionId);
}
