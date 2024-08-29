package com.interview.learning.machineCode.customerIssueResolutionSystem.service;

import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Customer;
import com.interview.learning.machineCode.customerIssueResolutionSystem.repository.CustomerRepository;

public class CustomerService {
    CustomerRepository customerRepository = InMemoryService.customerRepository;

    public void registerCustomer(String id ,String name , String email){
        Customer customer = new Customer(id,name,email);
        customerRepository.save(customer);

        System.out.println(customer);
    }
}
