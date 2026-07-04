package com.github.shivang.agentfolio.core.prompt;

import org.springframework.stereotype.Service;

import com.github.shivang.agentfolio.config.properties.AgentProperties;
import com.github.shivang.agentfolio.knowledge.provider.KnowledgeProvider;


import java.util.List;

import org.springframework.ai.chat.messages.Message;
import org.springframework.stereotype.Service;

import com.github.shivang.agentfolio.config.properties.AgentProperties;
import com.github.shivang.agentfolio.knowledge.provider.KnowledgeProvider;

@Service
public class PromptServiceImpl implements PromptService {

    private final AgentProperties agentProperties;
    private final KnowledgeProvider knowledgeProvider;

    public PromptServiceImpl(AgentProperties agentProperties,
                             KnowledgeProvider knowledgeProvider) {
        this.agentProperties = agentProperties;
        this.knowledgeProvider = knowledgeProvider;
    }

    @Override
    public String buildPrompt(List<Message> messages,String userMessage) {

        StringBuilder conversationHistory = new StringBuilder();

        for (Message message : messages) {
            conversationHistory.append(message.getMessageType())
                        .append(": ")
                        .append(message.getText())
                        .append(System.lineSeparator());
        }

        return String.format(
                SystemPromptTemplate.SYSTEM_PROMPT,
                agentProperties.owner(),
                knowledgeProvider.provideKnowledge(),
                conversationHistory,
                userMessage
        );
    }

	
}