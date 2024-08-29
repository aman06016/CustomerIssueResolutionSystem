package com.interview.learning.machineCode.customerIssueResolutionSystem.service;

import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Agent;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueType;

import java.util.List;

public class AdminService {

    AgentService agentService = InMemoryService.agentService;

    public void addAgent(String agentName , String email, List<IssueType> issueTypes ){
        agentService.addAgent(agentName,email, issueTypes);

    }
}
