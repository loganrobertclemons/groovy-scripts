import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.project.version.Version


def customFieldManager = ComponentAccessor.getCustomFieldManager()
def epicLinkCf = customFieldManager.getCustomFieldObjectByName("Epic Link")
def epicIssue = issue.getCustomFieldValue(epicLinkCf) as Issue
def targetRelCf = customFieldManager.getCustomFieldObjectByName("QA Deployment Target Date")


if (epicIssue) {
    return (epicIssue.getCustomFieldValue(targetRelCf))
}
