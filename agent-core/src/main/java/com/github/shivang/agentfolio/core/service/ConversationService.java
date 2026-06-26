package com.github.shivang.agentfolio.core.service;

import reactor.core.publisher.Flux;

public interface ConversationService {
    Flux<String> chat(String sessionId, String message);
}
