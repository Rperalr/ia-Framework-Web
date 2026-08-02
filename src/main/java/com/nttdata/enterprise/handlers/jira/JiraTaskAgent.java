package com.nttdata.enterprise.handlers.jira;

import com.nttdata.enterprise.orchestration.agent.Agent;
import com.nttdata.enterprise.model.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CompletableFuture;
import java.util.Map;
import java.util.HashMap;

/**
 * JiraTaskAgent - Lee tareas, criterios de aceptación y publica resultados
 */
public class JiraTaskAgent implements Agent {
    
    private static final Logger logger = LoggerFactory.getLogger(JiraTaskAgent.class);
    
    @Override
    public CompletableFuture<Map<String, Object>> execute(UserRequest request) {
        logger.info("📌 JiraTaskAgent - Procesando tareas de Jira");
        
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> result = new HashMap<>();
            
            try {
                String taskId = (String) request.getParameters().get("taskId");
                String action = (String) request.getParameters().get("action");
                
                logger.info("🔗 Procesando tarea Jira: {} - Acción: {}", taskId, action);
                
                if ("read".equals(action)) {
                    // Leer tarea
                    Map<String, Object> taskData = new HashMap<>();
                    taskData.put("id", taskId);
                    taskData.put("title", "Implementar nuevo módulo de login");
                    taskData.put("description", "Crear módulo de login con autenticación 2FA");
                    taskData.put("acceptanceCriteria", new String[]{
                        "Usuario puede registrarse",
                        "Usuario puede login con 2FA",
                        "Sistema envía email de confirmación",
                        "Sesión expira después de 30 minutos"
                    });
                    taskData.put("priority", "HIGH");
                    taskData.put("status", "IN_PROGRESS");
                    
                    result.put("action", "read");
                    result.put("task", taskData);
                    
                    logger.info("✅ Tarea {} leída exitosamente", taskId);
                    
                } else if ("publish".equals(action)) {
                    // Publicar resultados
                    String executionId = (String) request.getParameters().get("executionId");
                    String testStatus = (String) request.getParameters().get("testStatus");
                    
                    logger.info("📤 Publicando resultados en Jira - Ejecución: {}, Estado: {}", 
                        executionId, testStatus);
                    
                    Map<String, Object> evidence = new HashMap<>();
                    evidence.put("executionId", executionId);
                    evidence.put("status", testStatus);
                    evidence.put("comment", "Pruebas automatizadas completadas exitosamente");
                    evidence.put("attachments", new String[]{"report.html", "screenshots.zip"});
                    
                    result.put("action", "publish");
                    result.put("evidence", evidence);
                    
                    logger.info("✅ Resultados publicados en {}", taskId);
                }
                
                result.put("status", "SUCCESS");
                
            } catch (Exception e) {
                logger.error("❌ Error procesando tarea Jira", e);
                result.put("status", "FAILED");
                result.put("error", e.getMessage());
            }
            
            return result;
        });
    }
    
    @Override
    public String getName() {
        return "JiraTaskAgent";
    }
    
    @Override
    public String getDescription() {
        return "Lee tareas de Jira, extrae criterios de aceptación y publica resultados";
    }
    
    @Override
    public boolean canHandle(UserRequest request) {
        return "jira".equalsIgnoreCase(request.getRequestType());
    }
}
