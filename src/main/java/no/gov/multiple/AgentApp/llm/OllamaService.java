package no.gov.multiple.AgentApp.llm;
import org.springframework.ai.chat.client.ChatClient;

import org.springframework.stereotype.Service;

@Service
public class OllamaService {
    private final ChatClient chatClient;

    public OllamaService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String ask(String prompt) {
        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
