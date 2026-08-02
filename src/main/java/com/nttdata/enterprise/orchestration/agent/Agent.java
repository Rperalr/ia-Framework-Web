package com.nttdata.enterprise.orchestration.agent;

import com.nttdata.enterprise.model.UserRequest;
import java.util.concurrent.CompletableFuture;
import java.util.Map;

/**
 * Interfaz base para todos los agentes de orquestación
 */
public interface Agent {
    
    /**
     * Ejecutar lógica del agente de forma asincrónica
     */
    CompletableFuture<Map<String, Object>> execute(UserRequest request);
    
    /**
     * Obtener nombre del agente
     */
    String getName();
    
    /**
     * Obtener descripción del agente
     */
    String getDescription();
    
    /**
     * Validar si el agente puede procesar esta solicitud
     */
    boolean canHandle(UserRequest request);
}
