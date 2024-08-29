package com.interview.learning.machineCode.customerIssueResolutionSystem.service;

import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Agent;
import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Issue;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.IssueRepository;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.AgentState;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueType;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.AgentRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AgentService {
    private final AgentRepository agentRepository = InMemoryService.agentRepository;
    private final IssueRepository issueRepository = InMemoryService.issueRepository;

    public void addAgent(String agentName , String email, List<IssueType> issueTypes){
        Agent agent = new Agent();
        agent.setId(String.valueOf(new Date().getTime()));
        agent.setName(agentName);
        agent.setIssueTypes(issueTypes);
        agent.setEmail(email);
        agent.setAgentState((AgentState.available));

        agentRepository.save(agent);
        System.out.println(agent);

    }

    private void viewAgentWorkHistory(){
        for(Map.Entry<String,List<Issue>> entry :issueRepository.getMapOfAgentIdToIssues().entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
