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

    public void viewAgentWorkHistory(){
        for(Map.Entry<String,List<Issue>> entry :issueRepository.getMapOfAgentIdToIssues().entrySet()){
            Agent agent = agentRepository.findById(entry.getKey());
            System.out.println(String.format("issue of agent %s are = " , agent.getName()));

            for (var issue : entry.getValue()){
                System.out.println(issue);
            }

        }
    }
}
