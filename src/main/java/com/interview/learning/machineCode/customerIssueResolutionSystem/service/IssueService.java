package com.interview.learning.machineCode.customerIssueResolutionSystem.service;

import com.interview.learning.machineCode.customerIssueResolutionSystem.AgentAssignment.AgentAssignmentStategy;
import com.interview.learning.machineCode.customerIssueResolutionSystem.AgentAssignment.FifoAgentAssignmentStategy;
import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Customer;
import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Issue;
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
    private final CustomerRepository customerRepository = InMemoryService.customerRepository;

    public Issue createIssue(String transactionId,IssueType issueType , String subject, String desc, String email){
        Issue issue = new Issue();

        issue.setId(String.valueOf(UUID.randomUUID()));
        issue.setTransactionId(transactionId);
        issue.setIssueLog(desc);
        issue.setCustomerId(email);
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
        return issueRepository.getListOfIssues().stream().filter(issue -> customer.getId().equals(issue.getCustomerId())).collect(Collectors.toList());
    }

    public List<Issue> getIssue(IssueType issueType){
        return  issueRepository.getListOfIssues().stream().filter(issue -> issueType.equals(issue.getIssueType())).collect(Collectors.toList());
    }



    public void updateIssue(String issueId, IssueState issueState, String res){
        Issue issue = issueRepository.findById(issueId);
        issue.setIssueState(issueState);
        issue.setResolution(res);

    }

    public void resolveIssue(String issueId, String resoltion){
        Issue issue = issueRepository.findById(issueId);
        issue.setAgentId(resoltion);
        issue.setIssueState(IssueState.resolved);

    }
}
