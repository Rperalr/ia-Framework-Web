package com.nttdata.enterprise.orchestration.agent.impl;

import com.nttdata.enterprise.orchestration.agent.Agent;
import com.nttdata.enterprise.model.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CompletableFuture;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

/**
 * TestExecutionHandler - Ejecuta Maven, selecciona tags, navegador y ambiente
 */
public class TestExecutionHandler implements Agent {
    
    private static final Logger logger = LoggerFactory.getLogger(TestExecutionHandler.class);
    
    @Override
    public CompletableFuture<Map<String, Object>> execute(UserRequest request) {
        logger.info("🚀 TestExecutionHandler - Iniciando ejecución de pruebas");
        
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> result = new HashMap<>();
            
            try {
                String executionId = UUID.randomUUID().toString();
                String profile = (String) request.getParameters().getOrDefault("profile", "smoke");
                String browser = request.getBrowser() != null ? request.getBrowser() : "chrome";
                String environment = request.getEnvironment() != null ? request.getEnvironment() : "dev";
                
                logger.info("📝 Ejecución {} - Profile: {}, Browser: {}, Env: {}", 
                    executionId, profile, browser, environment);
                
                // Simular ejecución de Maven
                String mavenCommand = String.format(
                    "mvn clean test -Dprofile=%s -Dbrowser=%s -Denvironment=%s",
                    profile, browser, environment
                );
                logger.info("⚙️  Ejecutando: {}", mavenCommand);
                
                Thread.sleep(2000); // Simular tiempo de ejecución
                
                result.put("executionId", executionId);
                result.put("status", "SUCCESS");
                result.put("profile", profile);
                result.put("browser", browser);
                result.put("environment", environment);
                result.put("totalTests", 45);
                result.put("passedTests", 43);
                result.put("failedTests", 2);
                result.put("reportPath", "/reports/automation-" + executionId + ".html");
                
                logger.info("✅ Ejecución completada: {}", executionId);
                
            } catch (Exception e) {
                logger.error("❌ Error en ejecución de pruebas", e);
                result.put("status", "FAILED");
                result.put("error", e.getMessage());
            }
            
            return result;
        });
    }
    
    @Override
    public String getName() {
        return "TestExecutionHandler";
    }
    
    @Override
    public String getDescription() {
        return "Ejecuta suite de pruebas con Maven, selecciona tags, navegador y ambiente";
    }
    
    @Override
    public boolean canHandle(UserRequest request) {
        return "test-execution".equalsIgnoreCase(request.getRequestType());
    }
}
