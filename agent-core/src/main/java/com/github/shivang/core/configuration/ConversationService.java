package com.github.shivang.core.configuration;

import reactor.core.publisher.Flux;

public interface ConversationService {
    Flux<String> chat(String sessionId, String message);
}
