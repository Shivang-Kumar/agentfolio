package com.github.shivang.agentfolio.knowledge.exception;


public class KnowledgeException extends RuntimeException {

    public KnowledgeException(String message) {
        super(message);
    }

    public KnowledgeException(String message, Throwable cause) {
        super(message, cause);
    }
}