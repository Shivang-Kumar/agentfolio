package com.github.shivang.agentfolio.knowledge.validator;


import org.springframework.stereotype.Component;

import com.github.shivang.agentfolio.knowledge.exception.KnowledgeException;

@Component
public class KnowldgeValidator {

   
    public void validate(String knowledge) {

        if (knowledge == null || knowledge.isBlank()) {
            throw new KnowledgeException("portfolio.md must not be empty.");
        }
    }
}