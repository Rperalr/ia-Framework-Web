package com.nttdata.enterprise.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Solicitud de usuario para orquestación de pruebas
 */
public class UserRequest implements Serializable {
    
    private String id;
    private String userId;
    private String requestType; // test-execution, planning, design, jira-update, github-trigger
    private Map<String, Object> parameters;
    private List<String> tags;
    private String browser;
    private String environment;
    private String priority; // HIGH, MEDIUM, LOW
    private long timestamp;
    
    public UserRequest() {
        this.timestamp = System.currentTimeMillis();
        this.parameters = new HashMap<String, Object>();
        this.tags = new ArrayList<String>();
    }
    
    public UserRequest(String requestType, Map<String, Object> parameters) {
        this();
        this.requestType = requestType;
        this.parameters = parameters;
    }
    
    // Getters y Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getRequestType() {
        return requestType;
    }
    
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
    
    public Map<String, Object> getParameters() {
        return parameters;
    }
    
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
    
    public List<String> getTags() {
        return tags;
    }
    
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    public String getBrowser() {
        return browser;
    }
    
    public void setBrowser(String browser) {
        this.browser = browser;
    }
    
    public String getEnvironment() {
        return environment;
    }
    
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    
    public String getPriority() {
        return priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
