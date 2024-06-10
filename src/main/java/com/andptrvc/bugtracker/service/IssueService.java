package com.andptrvc.bugtracker.service;

import com.andptrvc.bugtracker.model.Issue;
import com.andptrvc.bugtracker.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public Issue createIssue(String parentIssueId, String description, String linkUrl) {
        Issue issue = new Issue();
        issue.setParentIssueId(parentIssueId);
        issue.setDescription(description);
        issue.setLinkUrl(linkUrl);
        return issueRepository.save(issue);
    }

    public Issue closeIssue(Long id) {
        Issue issue = issueRepository.findById(id).orElseThrow(() -> new RuntimeException("Issue not found"));
        issue.setStatus("Closed");
        return issueRepository.save(issue);
    }

    public List<Issue> listOpenIssues() {
        return issueRepository.findByStatus("Open");
    }
}
