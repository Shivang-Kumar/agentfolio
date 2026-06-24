package com.github.shivang.agentfolio.knowledge.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

import com.github.shivang.agentfolio.config.locator.AgentConfigDirectoryLocationResolver;
import com.github.shivang.agentfolio.knowledge.exception.KnowledgeException;

@Component
public class MarkdownKnowledgeLoader implements KnowledgeLoader {

    private static final String PORTFOLIO_FILE = "portfolio.md";

    private final AgentConfigDirectoryLocationResolver configDirectoryProvider;

    public MarkdownKnowledgeLoader(AgentConfigDirectoryLocationResolver configDirectoryProvider) {
        this.configDirectoryProvider = configDirectoryProvider;
    }

    @Override
    public String load() {

        Path portfolioFile = configDirectoryProvider
                .resolveConfigDirectoryLocation()
                .resolve(PORTFOLIO_FILE);

        try {
            return Files.readString(portfolioFile);
        } catch (IOException ex) {
            throw new KnowledgeException(
                    "Failed to load portfolio.md from " + portfolioFile,
                    ex);
        }
    }
}
