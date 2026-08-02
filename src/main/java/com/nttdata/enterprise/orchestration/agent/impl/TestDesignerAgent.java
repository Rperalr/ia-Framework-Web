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
 * TestDesignerAgent - Propone Features, escenarios, datos y localizadores
 */
public class TestDesignerAgent implements Agent {
    
    private static final Logger logger = LoggerFactory.getLogger(TestDesignerAgent.class);
    
    @Override
    public CompletableFuture<Map<String, Object>> execute(UserRequest request) {
        logger.info("🎨 TestDesignerAgent - Diseñando escenarios de pruebas");
        
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> result = new HashMap<>();
            
            try {
                String module = (String) request.getParameters().get("module");
                
                logger.info("🔍 Diseñando escenarios para módulo: {}", module);
                
                Map<String, Object> designedScenarios = new HashMap<>();
                
                // Proponer features
                List<String> features = new ArrayList<>();
                features.add("@login - Login de usuario");
                features.add("@logout - Logout de usuario");
                features.add("@cart - Gestión de carrito");
                features.add("@checkout - Proceso de compra");
                
                // Proponer datos de prueba
                Map<String, Object> testData = new HashMap<>();
                testData.put("users", new String[]{"user@test.com", "admin@test.com"});
                testData.put("passwords", new String[]{"password123", "admin123"});
                testData.put("products", new String[]{"Product1", "Product2", "Product3"});
                
                // Proponer localizadores
                Map<String, String> locators = new HashMap<>();
                locators.put("loginButton", "xpath://button[@id='login-btn']");
                locators.put("usernameInput", "css:input[name='username']");
                locators.put("passwordInput", "css:input[name='password']");
                locators.put("cartIcon", "id:cart-icon");
                locators.put("checkoutButton", "xpath://button[contains(text(), 'Checkout')]");
                
                designedScenarios.put("features", features);
                designedScenarios.put("testData", testData);
                designedScenarios.put("locators", locators);
                
                result.put("status", "SUCCESS");
                result.put("module", module);
                result.put("scenarios", designedScenarios);
                result.put("totalScenarios", features.size());
                
                logger.info("✅ Escenarios diseñados para {}", module);
                
            } catch (Exception e) {
                logger.error("❌ Error diseñando escenarios", e);
                result.put("status", "FAILED");
                result.put("error", e.getMessage());
            }
            
            return result;
        });
    }
    
    @Override
    public String getName() {
        return "TestDesignerAgent";
    }
    
    @Override
    public String getDescription() {
        return "Propone features, escenarios, datos de prueba y localizadores";
    }
    
    @Override
    public boolean canHandle(UserRequest request) {
        return "design".equalsIgnoreCase(request.getRequestType());
    }
}
