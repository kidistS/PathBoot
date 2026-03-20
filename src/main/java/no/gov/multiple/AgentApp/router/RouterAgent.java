package no.gov.multiple.AgentApp.router;

import no.gov.multiple.AgentApp.agent.MuliAgent;
import org.springframework.stereotype.Service;

@Service
public class RouterAgent {

    private final MuliAgent muliAgent;
    public RouterAgent(MuliAgent muliAgent) {
        this.muliAgent = muliAgent;
    }
    enum Domain {
        NAV,
        TAX,
        IMMIGRATION
    }


    public String routeQuery(String question) {
        String query = question.toLowerCase();
        if (question.contains("nav") || query.contains("unemployment") || query.contains("benefits")) {
            String domain = Domain.NAV.toString();
            return muliAgent.handleQuery(domain,question);
        } else if (query.contains("tax") || query.contains("income") || query.contains("deduction")) {
            String domain = Domain.TAX.toString();
            return muliAgent.handleQuery(domain,question);
        } else if (query.contains("immigration") || query.contains("visa") || query.contains("residency")) {
            String domain = Domain.IMMIGRATION.toString();
            return muliAgent.handleQuery(domain,question);
        } else {
            return "Sorry, I couldn't determine the domain of your question. Please specify if it's related to NAV, Tax, or Immigration.";
        }
    }

}