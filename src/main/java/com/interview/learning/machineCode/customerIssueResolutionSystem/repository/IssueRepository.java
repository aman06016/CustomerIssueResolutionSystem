package com.interview.learning.machineCode.customerIssueResolutionSystem.repository;

import com.interview.learning.machineCode.customerIssueResolutionSystem.model.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueRepository {

    private   Map<String , Issue> mapOfIdToIssue;
    private   Map<String, List<Issue>> mapOfAgentIdToIssues;
    private List<Issue>  listOfIssues;

    public  IssueRepository(){
        mapOfIdToIssue = new HashMap<>();
        mapOfAgentIdToIssues = new HashMap<>();
        listOfIssues = new ArrayList<>();
    }

    public Issue findById(String issueId){
        return mapOfIdToIssue.get(issueId);
    }

    public Map<String, Issue> getMapOfIdToIssue() {
        return mapOfIdToIssue;
    }

    public Issue save(Issue issue){
        mapOfIdToIssue.put(issue.getId(),issue);
        listOfIssues.add(issue);

        return issue;
    }

    public void setMapOfIdToIssue(Map<String, Issue> mapOfIdToIssue) {
        this.mapOfIdToIssue = mapOfIdToIssue;
    }

    public Map<String, List<Issue>> getMapOfAgentIdToIssues() {
        return mapOfAgentIdToIssues;
    }

    public void setMapOfAgentIdToIssues(Map<String, List<Issue>> mapOfAgentIdToIssues) {
        this.mapOfAgentIdToIssues = mapOfAgentIdToIssues;
    }

    public List<Issue> getListOfIssues() {
        return listOfIssues;
    }

    public void setListOfIssues(List<Issue> listOfIssues) {
        this.listOfIssues = listOfIssues;
    }
}
