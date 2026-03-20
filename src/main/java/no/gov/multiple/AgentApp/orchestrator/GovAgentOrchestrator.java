package no.gov.multiple.AgentApp.orchestrator;

import no.gov.multiple.AgentApp.router.RouterAgent;
import org.springframework.stereotype.Service;

@Service
public class GovAgentOrchestrator {
    private final RouterAgent router;

    public GovAgentOrchestrator(RouterAgent router) {
        this.router = router;
    }
   public String handleUserQuery(String question) {
        return router.routeQuery(question);
    }
}
