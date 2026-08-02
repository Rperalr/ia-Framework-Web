package com.nttdata.enterprise.orchestration.agent.impl;

import com.nttdata.enterprise.orchestration.agent.Agent;
import com.nttdata.enterprise.model.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CompletableFuture;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * OrchestratorAgent - Recibe solicitud del usuario y decide qué agente ejecutar
 * Actúa como coordinador central de todos los agentes disponibles
 */
public class OrchestratorAgent implements Agent {
    
    private static final Logger logger = LoggerFactory.getLogger(OrchestratorAgent.class);
    private List<Agent> availableAgents;
    
    public OrchestratorAgent(List<Agent> agents) {
        this.availableAgents = agents;
    }
    
    @Override
    public CompletableFuture<Map<String, Object>> execute(UserRequest request) {
        logger.info("🎯 OrchestratorAgent - Procesando solicitud: {}", request.getRequestType());
        
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> result = new HashMap<>();
            
            try {
                // Encontrar agente apropiado
                Agent selectedAgent = availableAgents.stream()
                    .filter(agent -> agent.canHandle(request))
                    .findFirst()
                    .orElse(null);
                
                if (selectedAgent == null) {
                    logger.warn("⚠️ No se encontró agente para procesar: {}", request.getRequestType());
                    result.put("status", "NO_HANDLER");
                    result.put("message", "No hay agente disponible para este tipo de solicitud");
                    return result;
                }
                
                logger.info("🔀 Enrutando a agente: {}", selectedAgent.getName());
                
                // Ejecutar agente seleccionado
                CompletableFuture<Map<String, Object>> agentResult = selectedAgent.execute(request);
                Map<String, Object> agentOutput = agentResult.get(); // Bloquear hasta que termine
                
                result.put("orchestratorStatus", "SUCCESS");
                result.put("selectedAgent", selectedAgent.getName());
                result.put("agentResult", agentOutput);
                
                logger.info("✅ Orquestación completada por: {}", selectedAgent.getName());
                
            } catch (Exception e) {
                logger.error("❌ Error en orquestación", e);
                result.put("status", "ERROR");
                result.put("error", e.getMessage());
            }
            
            return result;
        });
    }
    
    @Override
    public String getName() {
        return "OrchestratorAgent";
    }
    
    @Override
    public String getDescription() {
        return "Recibe solicitudes del usuario y enruta hacia el agente apropiado";
    }
    
    @Override
    public boolean canHandle(UserRequest request) {
        return true; // El orquestador siempre puede intentar procesar
    }
}
