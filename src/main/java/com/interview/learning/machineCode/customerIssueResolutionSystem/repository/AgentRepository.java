package com.interview.learning.machineCode.customerIssueResolutionSystem.repository;

import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Agent;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentRepository {

    private Map<String, Agent> mapOfIdToAgent;
    private List<Agent> listOfAgent;
    private Map<IssueType,List<Agent>> mapOfIssueTypeToAgent;

    public AgentRepository(){
        mapOfIdToAgent = new HashMap<>();
        listOfAgent = new ArrayList<>();
        mapOfIssueTypeToAgent = new HashMap<>();
    }

    public Agent save(Agent agent){
        listOfAgent.add(agent);
        mapOfIdToAgent.put(agent.getId(),agent);

        for(IssueType issueType : agent.getIssueTypes()){
            mapOfIssueTypeToAgent.computeIfAbsent(issueType,x-> new ArrayList<>());
            mapOfIssueTypeToAgent.get(issueType).add(agent);
        }
        return agent;
    }

    public List<Agent> getListOfAgentOfIssueType(IssueType issueType){
        return mapOfIssueTypeToAgent.get(issueType);
    }

    public Map<String, Agent> getMapOfIdToAgent() {
        return mapOfIdToAgent;
    }

    public void setMapOfIdToAgent(Map<String, Agent> mapOfIdToAgent) {
        this.mapOfIdToAgent = mapOfIdToAgent;
    }

    public List<Agent> getListOfAgent() {
        return listOfAgent;
    }

    public void setListOfAgent(List<Agent> listOfAgent) {
        this.listOfAgent = listOfAgent;
    }

    public Map<IssueType, List<Agent>> getMapOfIssueTypeToAgent() {
        return mapOfIssueTypeToAgent;
    }

    public void setMapOfIssueTypeToAgent(Map<IssueType, List<Agent>> mapOfIssueTypeToAgent) {
        this.mapOfIssueTypeToAgent = mapOfIssueTypeToAgent;
    }


}
