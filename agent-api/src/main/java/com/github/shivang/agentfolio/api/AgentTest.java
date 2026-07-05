package com.github.shivang.agentfolio.api;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

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
    public Flux<String> chat(@RequestParam String sessionId ,@RequestParam String message) {

        return conversationService.chat(sessionId, message);
    }
    
    @Bean
    CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Allows any website in the world to make requests to this backend
        config.addAllowedOriginPattern("*"); 
        
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}