import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.component.ComponentAccessor;

IssueManager issueManager = ComponentAccessor.getIssueManager();
tickets = issueManager.getAllIssueKeys(issue.id)


return tickets
