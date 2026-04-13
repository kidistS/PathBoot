# PathBoot Project Documentation

## Project Overview
PathBoot is a Java Spring Boot web application that integrates Spring AI with a locally running Ollama server to enable chat/assistant capabilities backed by an on-device LLM.

## Architecture Artifacts
- `AgentApp-Architecture.d2`
- `d2_diagram .png`

## Prerequisites
- Java 17
- Maven
- Ollama

### Install Ollama
Follow the official Ollama installation guide:
- https://docs.ollama.com/

## Configuration
Application configuration is in:
- `src/main/resources/application.properties`

Current default settings:
- `spring.ai.ollama.base-url=http://localhost:11434`
- `spring.ai.ollama.chat.model=mistral`
- `app.ollama.auto-pull=true`

## Run locally
1. Start Ollama (ensure it is reachable at `http://localhost:11434`).
2. Pull the model configured in `application.properties` (default: `mistral`):
   ```bash
   ollama pull mistral
   ```
3. Run the Spring Boot app:
   ```bash
   mvn spring-boot:run
   ```

## Change the model
Edit `spring.ai.ollama.chat.model` in `src/main/resources/application.properties` to any model you have available in Ollama.

## Notes
- The repository currently has no top-level `agents/` directory visible on the `main` branch. If you expected it, it may be on another branch or under a different path.