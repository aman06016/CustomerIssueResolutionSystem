package com.interview.learning.machineCode.customerIssueResolutionSystem.model;

import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueState;
import com.interview.learning.machineCode.customerIssueResolutionSystem.states.IssueType;

import java.util.Date;

public class Issue {
    private String id;
    private String transactionId;
    private IssueType issueType;
    private String customerId;
    private String subject;
    private String issueLog;
    private IssueState issueState;
    private String resolution;
    private String agentId;
    private Date createdAt;

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", issueType=" + issueType +
                ", customerId='" + customerId + '\'' +
                ", subject='" + subject + '\'' +
                ", issueLog='" + issueLog + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getIssueLog() {
        return issueLog;
    }

    public void setIssueLog(String issueLog) {
        this.issueLog = issueLog;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public IssueState getIssueState() {
        return issueState;
    }

    public void setIssueState(IssueState issueState) {
        this.issueState = issueState;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
