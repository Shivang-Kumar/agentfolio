package com.github.shivang.agentfolio.core.prompt;

import java.util.List;

import org.springframework.ai.chat.messages.Message;

public interface PromptService {
    String buildPrompt(List<Message> message,String userMessage);
}