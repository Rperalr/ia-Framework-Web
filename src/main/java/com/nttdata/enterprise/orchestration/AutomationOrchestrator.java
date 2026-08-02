package com.nttdata.enterprise.orchestration;

import com.nttdata.enterprise.mcp.MCPFrameworkServer;
import com.nttdata.enterprise.orchestration.agent.Agent;
import com.nttdata.enterprise.orchestration.agent.impl.*;
import com.nttdata.enterprise.handlers.jira.JiraTaskAgent;
import com.nttdata.enterprise.handlers.github.GitHubActionsAgent;
import com.nttdata.enterprise.model.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * AutomationOrchestrator - Sistema central de orquestación de agentes de automatización
 * 
 * Orden de ejecución recomendado:
 * 1. MCPFrameworkServer - Expone herramientas controladas
 * 2. TestExecutionHandler - Ejecuta Maven y pruebas
 * 3. OrchestratorAgent - Coordina agentes
 * 4. TestPlanningAgent - Genera planes
 * 5. TestDesignerAgent - Diseña escenarios
 * 6. JiraTaskAgent - Gestiona tareas Jira
 * 7. GitHubActionsAgent - Gestiona CI/CD
 */
public class AutomationOrchestrator {
    
    private static final Logger logger = LoggerFactory.getLogger(AutomationOrchestrator.class);
    
    private MCPFrameworkServer mcpServer;
    private OrchestratorAgent orchestrator;
    private List<Agent> agents;
    
    public AutomationOrchestrator() {
        initialize();
    }
    
    /**
     * Inicializar el orquestador con todos los agentes
     */
    private void initialize() {
        logger.info("🚀 Inicializando AutomationOrchestrator...");
        
        // 1. Inicializar MCP Framework Server
        this.mcpServer = new MCPFrameworkServer();
        logger.info("✅ MCP Framework Server inicializado");
        
        // 2-7. Crear instancias de todos los agentes
        this.agents = new ArrayList<Agent>();
        
        // En orden de ejecución
        agents.add(new TestExecutionHandler());
        agents.add(new TestPlanningAgent());
        agents.add(new TestDesignerAgent());
        agents.add(new JiraTaskAgent());
        agents.add(new GitHubActionsAgent());
        
        // 3. Crear OrquestadorAgent con lista de agentes disponibles
        this.orchestrator = new OrchestratorAgent(agents);
        
        logger.info("✅ Todos los agentes inicializados");
        logger.info("📊 Agentes disponibles:");
        for (Agent agent : agents) {
            logger.info("   - {}: {}", agent.getName(), agent.getDescription());
        }
        logger.info("🔧 Herramientas MCP disponibles: {}", mcpServer.listAllTools().size());
    }
    
    /**
     * Procesar solicitud del usuario
     */
    public CompletableFuture<Map<String, Object>> processRequest(UserRequest request) {
        logger.info("📥 Procesando solicitud: tipo={}, usuario={}", 
            request.getRequestType(), request.getUserId());
        
        return orchestrator.execute(request)
            .thenApply(new java.util.function.Function<Map<String, Object>, Map<String, Object>>() {
                @Override
                public Map<String, Object> apply(Map<String, Object> result) {
                    logger.info("📤 Solicitud procesada - Estado: {}", 
                        result.get("orchestratorStatus"));
                    return result;
                }
            })
            .exceptionally(new java.util.function.Function<Throwable, Map<String, Object>>() {
                @Override
                public Map<String, Object> apply(Throwable ex) {
                    logger.error("❌ Error procesando solicitud", ex);
                    Map<String, Object> error = new HashMap<String, Object>();
                    error.put("status", "ERROR");
                    error.put("error", ex.getMessage());
                    return error;
                }
            });
    }
    
    /**
     * Obtener agente por nombre
     */
    public Agent getAgent(String agentName) {
        for (Agent agent : agents) {
            if (agent.getName().equals(agentName)) {
                return agent;
            }
        }
        return null;
    }
    
    /**
     * Listar todos los agentes disponibles
     */
    public List<Agent> getAvailableAgents() {
        return new ArrayList<Agent>(agents);
    }
    
    /**
     * Obtener MCP Framework Server
     */
    public MCPFrameworkServer getMCPServer() {
        return mcpServer;
    }
    
    /**
     * Ejemplo de uso
     */
    public static void main(String[] args) throws Exception {
        logger.info("🎯 Iniciando AutomationOrchestrator Demo");
        
        AutomationOrchestrator orchestrator = new AutomationOrchestrator();
        
        // Ejemplo 1: Solicitud de ejecución de pruebas
        UserRequest testRequest = new UserRequest();
        testRequest.setId("req-001");
        testRequest.setUserId("user@company.com");
        testRequest.setRequestType("test-execution");
        testRequest.setBrowser("chrome");
        testRequest.setEnvironment("staging");
        Map<String, Object> params1 = new HashMap<String, Object>();
        params1.put("profile", "regression");
        testRequest.setParameters(params1);
        
        logger.info("\n📋 Ejemplo 1: Ejecución de pruebas");
        CompletableFuture<Map<String, Object>> result1 = orchestrator.processRequest(testRequest);
        result1.get(); // Esperar resultado
        
        // Ejemplo 2: Solicitud de planificación
        UserRequest planRequest = new UserRequest();
        planRequest.setId("req-002");
        planRequest.setUserId("user@company.com");
        planRequest.setRequestType("planning");
        Map<String, Object> params2 = new HashMap<String, Object>();
        params2.put("testObjective", "Verificar flujo de compra");
        List<String> features = new ArrayList<String>();
        features.add("login");
        features.add("checkout");
        features.add("payment");
        params2.put("features", features);
        planRequest.setParameters(params2);
        
        logger.info("\n📋 Ejemplo 2: Planificación de pruebas");
        CompletableFuture<Map<String, Object>> result2 = orchestrator.processRequest(planRequest);
        result2.get(); // Esperar resultado
        
        logger.info("\n✅ Demo completada");
    }
}
