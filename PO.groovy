import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.project.version.Version


def customFieldManager = ComponentAccessor.getCustomFieldManager()
def epicLinkCf = customFieldManager.getCustomFieldObjectByName("Epic Link")
def epicIssue = issue.getCustomFieldValue(epicLinkCf) as Issue
def targetRelCf = customFieldManager.getCustomFieldObjectByName("PO Assigned")


if (epicIssue) {
    return (epicIssue.getCustomFieldValue(targetRelCf))
}
