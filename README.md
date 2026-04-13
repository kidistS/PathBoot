# PathBoot Project Documentation

## Project Overview
This project is designed to provide robust solutions for AI chat applications. Its primary components and interactions are outlined below.

## Architecture Artifacts
- **AgentApp-Architecture.d2**  
- **d2_diagram.png**  

## Prerequisites
To get started with this project, ensure you have the following installed:
- Java 17
- Maven
- Ollama

## Configuration
You can configure the application properties in the following file:
```
src/main/resources/application.properties
```
Make sure to include the following configurations:
```
spring.ai.ollama.base-url={your_base_url}
spring.ai.ollama.chat.model={model_name}
app.ollama.auto-pull=true
```

## How to Run
To get the application up and running, execute the following commands:
1. Start the Ollama server:
   ```
   ollama serve
   ```
2. Pull the required model:
   ```
   ollama pull mistral
   ```
3. Run the Spring Boot application:
   ```
   mvn spring-boot:run
   ```

## How to Change the Model
To change the model, modify the `spring.ai.ollama.chat.model` entry in the `application.properties` file to your desired model name.

## Troubleshooting Tips
- If you encounter issues, please check that all prerequisites are correctly installed and configured.
- Verify that the base URL for Ollama is accessible.

> **Note:** The repository currently has no top-level agents/ directory visible on the main branch.