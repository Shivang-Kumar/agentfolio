package com.github.shivang.agentfolio.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.shivang.agentfolio.core.service.ConversationService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/chat")
public class AgentTest {

    private final ConversationService conversationService;

    public AgentTest(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> chat(@RequestParam String message) {

        return conversationService.chat("test-session", message);
    }
}