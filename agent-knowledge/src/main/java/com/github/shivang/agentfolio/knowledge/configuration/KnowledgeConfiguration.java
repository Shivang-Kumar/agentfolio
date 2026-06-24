package com.github.shivang.agentfolio.knowledge.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.shivang.agentfolio.knowledge.loader.KnowledgeLoader;
import com.github.shivang.agentfolio.knowledge.provider.KnowledgeProvider;
import com.github.shivang.agentfolio.knowledge.provider.MarkdownKnowledgeProvider;
import com.github.shivang.agentfolio.knowledge.validator.KnowldgeValidator;

@Configuration
public class KnowledgeConfiguration {

    @Bean
    public KnowledgeProvider knowledgeProvider(
            KnowledgeLoader loader,
            KnowldgeValidator validator) {

        String knowledge = loader.load();
        validator.validate(knowledge);

        return new MarkdownKnowledgeProvider(knowledge);
    }
}