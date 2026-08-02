package com.nttdata.enterprise.mcp;

import java.util.Map;
import java.io.Serializable;

/**
 * Representa una herramienta disponible en el MCP Framework
 */
public class MCPTool implements Serializable {
    
    private String name;
    private String description;
    private Map<String, String> parameters;
    
    public MCPTool(String name, String description, Map<String, String> parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Map<String, String> getParameters() {
        return parameters;
    }
    
    @Override
    public String toString() {
        return String.format("MCPTool{name='%s', description='%s'}", name, description);
    }
}
