package com.interview.learning.machineCode.customerIssueResolutionSystem.service;

import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.AgentRepository;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.CustomerRepository;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.IssueRepository;

public  class InMemoryService {

    public static CustomerRepository customerRepository;
    public static AgentRepository agentRepository;
    public static IssueRepository issueRepository;

    public static AgentService agentService;
    public static CustomerService customerService;
    public static IssueService issueService;
    public static AdminService adminService;

    public InMemoryService(){
        customerRepository  = new CustomerRepository();
        agentRepository = new AgentRepository();
        issueRepository = new IssueRepository();

        agentService = new AgentService();
        customerService = new CustomerService();
        issueService = new IssueService();
        adminService = new AdminService();
    }
}
