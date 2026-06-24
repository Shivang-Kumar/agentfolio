package com.github.shivang.agentfolio.knowledge.provider;



public class MarkdownKnowledgeProvider implements KnowledgeProvider {

    private final String knowledge;

    public MarkdownKnowledgeProvider(String knowledge) {
        this.knowledge = knowledge;
    }


	@Override
	public String provideKnowledge() {
		return knowledge;
	}
}