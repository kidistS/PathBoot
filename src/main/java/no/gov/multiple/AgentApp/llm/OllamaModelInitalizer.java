package no.gov.multiple.AgentApp.llm;

import no.gov.multiple.AgentApp.config.AppConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Component
public class OllamaModelInitalizer implements ApplicationRunner
{
    private final RestClient restClient;

    private final String modelName = AppConfig.get("spring.ai.ollama.chat.model");
    String baseUrl = AppConfig.get("spring.ai.ollama.base-url");
    private final boolean autoPull = AppConfig.get("app.ollama.auto-pull").equalsIgnoreCase("true");

    public OllamaModelInitalizer(RestClient.Builder restClientBuilder){
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(!autoPull){
            System.out.println("Auto-pull is disabled. Skipping model pull.");
            return;
        }
        try{
            System.out.println("Pulling Ollama model...");
            TagsResponse tagsResponse = restClient.get()
                    .uri("/api/tags")
                    .retrieve()
                    .body(TagsResponse.class);

            boolean exists = tagsResponse != null
                    && tagsResponse.models() != null
                    && Arrays.stream(tagsResponse.models())
                    .map(ModelInfo::name)
                    .filter(Objects::nonNull)
                    .anyMatch(name -> name.equalsIgnoreCase(modelName));


            if(exists){
                System.out.println("Model already exists. No pull needed.");
                return;
            }
            System.out.println("Model not found. Pulling model..." + modelName);

            restClient.post()
                    .uri("/api/pull")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Map.of("model", modelName, "stream", false))
                    .retrieve()
                    .toBodilessEntity();
            System.out.println("Model pull completed.");

        }catch (Exception e){
            System.err.println("Failed to pull model: " + e.getMessage());
        }
    }
    public record TagsResponse(ModelInfo[] models) {}
    public record ModelInfo(String name) {}
}
