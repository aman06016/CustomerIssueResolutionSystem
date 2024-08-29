package com.interview.learning.machineCode.customerIssueResolutionSystem.AgentAssignment;

import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Agent;
import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Issue;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueType;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.AgentRepository;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.IssueRepository;
import com.interview.learning.machineCode.customerIssueResolutionSystem.service.InMemoryService;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.AgentState;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueState;

import java.util.List;
import java.util.Optional;

public class FifoAgentAssignmentStategy implements AgentAssignmentStategy{

    private final static AgentRepository agentRepository = InMemoryService.agentRepository;
    private final static IssueRepository issueRepository = InMemoryService.issueRepository;

    @Override
    public void assignAgent(String issueId) {
        Issue issue = issueRepository.findById(issueId);

        IssueType issueType = issue.getIssueType();
        List<Agent> listOfAgentsForThisIssueType = agentRepository.getListOfAgentOfIssueType(issueType);
        Optional<Agent> availableAgent = listOfAgentsForThisIssueType.stream().filter(a -> a.getAgentState().equals(AgentState.available)).findFirst();


        if(availableAgent.isPresent()){
            var agent = availableAgent.get();
            issue.setAgentId(agent.getId());
            issue.setIssueState(IssueState.picked);
            agent.setAgentState(AgentState.busy);
            System.out.println(String.format("%s is assign to %s" , "issue " + issue.getAgentId() , agent.getName()));
        }
    }
}
