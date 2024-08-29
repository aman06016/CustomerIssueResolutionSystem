package com.interview.learning.machineCode.customerIssueResolutionSystem.model;

import com.interview.learning.machineCode.customerIssueResolutionSystem.states.AgentState;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueType;

import java.util.List;

public class Agent {
    private String id;
    private String name;
    private String email;
    private List<IssueType> issueTypes;
    private AgentState agentState;

    public Agent() {
    }

    public Agent(String id, List<IssueType> issueTypes, String name, String email) {
        this.id = id;
        this.issueTypes = issueTypes;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", issueTypes=" + issueTypes +
                ", agentState=" + agentState +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<IssueType> getIssueTypes() {
        return issueTypes;
    }

    public void setIssueTypes(List<IssueType> issueTypes) {
        this.issueTypes = issueTypes;
    }

    public AgentState getAgentState() {
        return agentState;
    }

    public void setAgentState(AgentState agentState) {
        this.agentState = agentState;
    }
}
