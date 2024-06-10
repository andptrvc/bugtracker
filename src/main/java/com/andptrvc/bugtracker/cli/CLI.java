package com.andptrvc.bugtracker.cli;

import com.andptrvc.bugtracker.model.Issue;
import com.andptrvc.bugtracker.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class CLI implements CommandLineRunner {

    @Autowired
    private IssueService issueService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String cliInput;

        while (true) {
            System.out.print("> ");
            cliInput = scanner.nextLine();
            if(!cliInput.isEmpty()) {
                String[] parts = cliInput.split(" ", 2);
                String[] inputs = new String[0];
                if(parts.length == 2) {
                     inputs = parts[1].split("\"\\s+\"");
                }
                switch (parts[0]) {
                    case "create":
                            handleCreate(inputs);
                        break;
                    case "close":
                            handleClose(inputs);
                        break;
                    case "list":
                        handleList();
                        break;
                    case "exit":
                        return;
                    default:
                        System.out.println("Unknown command");
                }
            } else {
                System.out.println("Please enter a command");
            }
        }
    }

    private void handleCreate(String[] parts) {
        if (parts.length < 3) {
            System.out.println("Usage: create \"<parentIssueId>\" \"<description>\" \"<linkUrl>\"");
            return;
        }
        String parentIssueId = parts[0].replaceAll("\"", "");
        String description = parts[1].replaceAll("\"", "");
        String linkUrl = parts[2].replaceAll("\"", "");
        Issue issue = issueService.createIssue(parentIssueId, description, linkUrl);
        System.out.println("Issue created with ID: " + issue.getId());
    }

    private void handleClose(String[] parts) {
        if (parts.length == 0) {
            System.out.println("Please enter an id");
        } else {
        try {
            Long id = Long.parseLong(parts[0].replaceAll("\"", ""));
            Issue issue = issueService.closeIssue(id);
            System.out.println("Issue with ID: " + id + " closed.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid issue ID");
        }
        }
    }

    private void handleList() {
        List<Issue> issues = issueService.listOpenIssues();
        if (issues.isEmpty()) {
            System.out.println("There are no open issues");
        } else {
            issues.forEach(issue -> System.out.println(issue.toString()));
        }
    }
}
