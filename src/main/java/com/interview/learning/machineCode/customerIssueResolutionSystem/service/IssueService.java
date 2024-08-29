package com.interview.learning.machineCode.customerIssueResolutionSystem.service;

import com.interview.learning.machineCode.customerIssueResolutionSystem.AgentAssignment.AgentAssignmentStategy;
import com.interview.learning.machineCode.customerIssueResolutionSystem.AgentAssignment.FifoAgentAssignmentStategy;
import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Agent;
import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Customer;
import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Issue;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.AgentRepository;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.AgentState;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueType;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.CustomerRepository;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.IssueRepository;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueState;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class IssueService {

    private final IssueRepository issueRepository = InMemoryService.issueRepository;
    private final AgentRepository agentRepository = InMemoryService.agentRepository;
    private final CustomerRepository customerRepository = InMemoryService.customerRepository;

    public Issue createIssue(String transactionId,IssueType issueType , String subject, String desc, String email){
        Issue issue = new Issue();
        Customer customer = customerRepository.findByEmail(email);


        issue.setId(String.valueOf(UUID.randomUUID()));
        issue.setTransactionId(transactionId);
        issue.setIssueLog(desc);
        issue.setCustomerId(customer.getId());
        issue.setIssueType(issueType);
        issue.setCreatedAt(new Date());
        issue.setSubject(subject);

        issueRepository.save(issue);

        System.out.println(issue);
        return issue;
    }

    public void assignIssue(String issueId){
        AgentAssignmentStategy agentAssignmentStategy = getAssignmentStartegy();
        agentAssignmentStategy.assignAgent(issueId);
    }

    private  FifoAgentAssignmentStategy getAssignmentStartegy() {
        return new FifoAgentAssignmentStategy();
    }

    public List<Issue> getIssues(String customerEmail){
        Customer customer = customerRepository.findByEmail(customerEmail);
        List<Issue> issues = issueRepository.getListOfIssues().stream().filter(issue -> customer.getId().equals(issue.getCustomerId())).collect(Collectors.toList());
        System.out.println(String.format("issues of %s are = " , customer.getEmail()));
        for(Issue issue:issues){
            System.out.println(issue);
        }
        return issues;
    }

    public List<Issue> getIssue(IssueType issueType){
        List<Issue> issues =   issueRepository.getListOfIssues().stream().filter(issue -> issueType.equals(issue.getIssueType())).collect(Collectors.toList());
        System.out.println(String.format("issues of issue type %s are = ",issueType.toString()));
        for(Issue issue:issues){
            System.out.println(issue);
        }
        return issues;
    }

    public void resolveIssue(String id, String message){
        Issue issue =  issueRepository.findById(id);
        issue.setResolution(message);
        issue.setIssueState(IssueState.resolved);

        Agent agent = agentRepository.findById(issue.getAgentId());
        agent.setAgentState(AgentState.available);

        System.out.println(String.format("issue %s has been resolved with message %s " , id,message));
    }


    public void updateIssue(String issueId, IssueState issueState, String res){
        Issue issue = issueRepository.findById(issueId);
        issue.setIssueState(issueState);
        issue.setResolution(res);
    }
}
