package com.interview.learning.machineCode.customerIssueResolutionSystem;

import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Agent;
import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Customer;
import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Issue;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.AgentRepository;
import com.interview.learning.machineCode.customerIssueResolutionSystem.service.*;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueType;

import java.util.List;
import java.util.Scanner;

public class Driver {



    public static void main(String[] args) {
        InMemoryService inMemoryService = new InMemoryService();

        AgentService agentService = InMemoryService.agentService;
        CustomerService customerService = InMemoryService.customerService;
        IssueService issueService = InMemoryService.issueService;
        AdminService adminService = InMemoryService.adminService;


        // adding agent
        adminService.addAgent("tanu","tanu@mail.com", List.of(IssueType.MFIssue,IssueType.goldIssue));
        adminService.addAgent("koyal","koyal@mail.com", List.of(IssueType.MFIssue,IssueType.goldIssue));

        // adding customers
        customerService.registerCustomer("1","aman","aman@mail.com");
        customerService.registerCustomer("2","aryan" , "aryan@mail.com");

        // creating issues
        Issue i1 = issueService.createIssue("T1", IssueType.MFIssue, "Payment Failed", "My payment failed but money is debited", "aman@mail.com");
        Issue i2 = issueService.createIssue("T2", IssueType.MFIssue, "Payment Failed", "My payment failed but money is debited", "aryan@mail.com");
        Issue i3 = issueService.createIssue("T3", IssueType.MFIssue, "Payment Failed", "My payment failed but money is debited", "aryan@mail.com");

        issueService.assignIssue(i1.getId());
        issueService.assignIssue(i2.getId());
        issueService.assignIssue(i3.getId());











    }
}
