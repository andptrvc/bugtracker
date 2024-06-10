package com.andptrvc.bugtracker.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parentIssueId;
    private String description;
    private String linkUrl;
    private String status = "Open";
    private LocalDateTime creationTimestamp = LocalDateTime.now();

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentIssueId() {
        return parentIssueId;
    }

    public void setParentIssueId(String parentIssueId) {
        this.parentIssueId = parentIssueId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", parentIssueId='" + parentIssueId + '\'' +
                ", description='" + description + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", status='" + status + '\'' +
                ", creationTimestamp=" + creationTimestamp +
                '}';
    }
}
