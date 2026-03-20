package no.gov.multiple.AgentApp.agent;

import no.gov.multiple.AgentApp.llm.OllamaService;
import no.gov.multiple.AgentApp.rag.RAGService;
import org.springframework.stereotype.Service;

@Service
public class MuliAgent {
    private final RAGService ragService;
    private final OllamaService ollamaService;

    public MuliAgent(RAGService ragService, OllamaService ollamaService) {
        this.ragService = ragService;
        this.ollamaService = ollamaService;
    }

    public String handleQuery(String domain, String question) {
        // Step 1: Get context using RAG
        String context = ragService.geyContext(domain, question);

        // Step 2: Formulate prompt for LLM
        String prompt = "Given the following context, answer the question:\n\nContext: " + context + "\n\nQuestion: " + question;

        // Step 3: Get response from LLM
        return ollamaService.ask(prompt);
    }
}
