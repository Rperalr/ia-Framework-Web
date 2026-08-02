package com.nttdata.enterprise.mcp;

import java.util.Map;
import java.io.Serializable;

/**
 * Resultado de la ejecución de una herramienta MCP
 */
public class MCPToolResult implements Serializable {
    
    private boolean success;
    private String message;
    private Map<String, Object> data;
    private long executionTime;
    
    public MCPToolResult(boolean success, String message, Map<String, Object> data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.executionTime = System.currentTimeMillis();
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Map<String, Object> getData() {
        return data;
    }
    
    public long getExecutionTime() {
        return executionTime;
    }
    
    @Override
    public String toString() {
        return String.format("MCPToolResult{success=%s, message='%s'}", success, message);
    }
}
