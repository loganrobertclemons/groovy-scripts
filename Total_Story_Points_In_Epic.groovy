import com.atlassian.jira.ComponentAccessor
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.component.ComponentAccessor;
def issueLinkManager = ComponentAccessor.getIssueLinkManager()
def cfManager = ComponentAccessor.getCustomFieldManager()
double totalSP = 0
customField = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("Story Points")

issueLinkManager.getOutwardLinks(issue.id)?.each{issueLink ->;
    if (issueLink.issueLinkType.name == "Epic-Story Link" ) {
        double SP = (double)(issueLink.destinationObject.getCustomFieldValue(customField) ?: 0)
        totalSP = SP + totalSP;
}}
return totalSP
