package com.github.shivang.core.configuration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Override
    public Flux<String> chat(String sessionId, String message) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
