package com.nttdata.enterprise.orchestration.agent.impl;

import com.nttdata.enterprise.orchestration.agent.Agent;
import com.nttdata.enterprise.model.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CompletableFuture;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * TestPlanningAgent - Analiza requerimientos y genera plan de pruebas
 */
public class TestPlanningAgent implements Agent {
    
    private static final Logger logger = LoggerFactory.getLogger(TestPlanningAgent.class);
    
    @Override
    public CompletableFuture<Map<String, Object>> execute(UserRequest request) {
        logger.info("📋 TestPlanningAgent - Generando plan de pruebas");
        
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> result = new HashMap<>();
            
            try {
                // Analizar parámetros de solicitud
                String testObjective = (String) request.getParameters().get("testObjective");
                List<String> features = (List<String>) request.getParameters().get("features");
                
                logger.info("📊 Objetivo: {}", testObjective);
                logger.info("📌 Funcionalidades: {}", features);
                
                // Generar plan de pruebas
                Map<String, Object> testPlan = new HashMap<>();
                testPlan.put("planId", "TP-" + System.nanoTime());
                testPlan.put("createdAt", System.currentTimeMillis());
                testPlan.put("objective", testObjective);
                testPlan.put("features", features);
                testPlan.put("testCases", generateTestCases(features));
                testPlan.put("estimatedDuration", "2-3 horas");
                testPlan.put("priority", request.getPriority() != null ? request.getPriority() : "MEDIUM");
                
                result.put("status", "SUCCESS");
                result.put("testPlan", testPlan);
                result.put("testCasesCount", features != null ? features.size() * 3 : 0);
                
                logger.info("✅ Plan de pruebas generado exitosamente");
                
            } catch (Exception e) {
                logger.error("❌ Error generando plan de pruebas", e);
                result.put("status", "FAILED");
                result.put("error", e.getMessage());
            }
            
            return result;
        });
    }
    
    private List<Map<String, String>> generateTestCases(List<String> features) {
        List<Map<String, String>> testCases = new ArrayList<>();
        
        if (features != null) {
            for (String feature : features) {
                for (int i = 1; i <= 3; i++) {
                    Map<String, String> testCase = new HashMap<>();
                    testCase.put("id", "TC-" + feature.hashCode() + "-" + i);
                    testCase.put("feature", feature);
                    testCase.put("scenario", feature + " - Escenario " + i);
                    testCases.add(testCase);
                }
            }
        }
        
        return testCases;
    }
    
    @Override
    public String getName() {
        return "TestPlanningAgent";
    }
    
    @Override
    public String getDescription() {
        return "Analiza requerimientos y genera plan de pruebas detallado";
    }
    
    @Override
    public boolean canHandle(UserRequest request) {
        return "planning".equalsIgnoreCase(request.getRequestType());
    }
}
