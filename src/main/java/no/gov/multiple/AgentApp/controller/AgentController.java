package no.gov.multiple.AgentApp.controller;

import no.gov.multiple.AgentApp.orchestrator.GovAgentOrchestrator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agent")
public class AgentController {
    private final GovAgentOrchestrator orchestrator;

    public AgentController(GovAgentOrchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }

    @GetMapping("/ping")
    public String testEndpoint() {
        return "Ping!";
    }
    @PostMapping("/ask")
    public String handleQuery(@RequestBody String ask) {
        return orchestrator.handleUserQuery(ask);
    }

}
