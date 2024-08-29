package com.interview.learning.machineCode.customerIssueResolutionSystem.repository;

import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Customer;

import java.util.*;

public class CustomerRepository {

    private List<Customer> customers;
    private Map<String,Customer> mapOfIdToCustomer;

    public CustomerRepository(){
        customers = new ArrayList<>();
        mapOfIdToCustomer = new HashMap<>();
    }

    public Customer findById(String id){
        return mapOfIdToCustomer.get(id);
    }
    public Customer findByEmail(String email){
        return customers.stream().filter(customer -> email.equals(customer.getEmail())).findFirst().get();
    }

    public Customer save(Customer customer){
        customers.add(customer);
        mapOfIdToCustomer.put(customer.getId(),customer);
        return customer;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, Customer> getMapOfIdToCustomer() {
        return mapOfIdToCustomer;
    }

    public void setMapOfIdToCustomer(Map<String, Customer> mapOfIdToCustomer) {
        this.mapOfIdToCustomer = mapOfIdToCustomer;
    }


}
