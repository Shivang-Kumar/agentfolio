package com.github.shivang.agentfolio.service;

import java.util.List;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultConversationMemoryService
        implements ConversationMemoryService {

	
	@Autowired
    ChatMemory chatMemory;

	@Override
	public List<Message> getConversation(String sessionId) {
		return chatMemory.get(sessionId);
	}

	@Override
	public void addMessage(String sessionId, Message message) {
		chatMemory.add(sessionId, message);
	}

	@Override
	public void clearConversation(String sessionId) {
			chatMemory.clear(sessionId);
	}

}