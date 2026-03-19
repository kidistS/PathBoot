package no.gov.multiple.AgentApp.model;

import java.time.LocalDateTime;

public record Message(
        String role,
        String content,
        String sessionId,
        LocalDateTime timestamp
) {
}
