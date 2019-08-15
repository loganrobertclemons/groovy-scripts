import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.issue.changehistory.ChangeHistoryManager
import com.atlassian.jira.issue.history.ChangeItemBean

String fieldName = 'LCPR Priority'

ChangeHistoryManager changeHistoryManager = ComponentAccessor.getChangeHistoryManager()

List<ChangeItemBean> changeItems
changeItems = changeHistoryManager.getChangeItemsForField(issue, fieldName)
if (changeItems.size()> 0) {
    changeItems.sort{it.getCreated()}.last().getCreated()
}
else {
    return issue.getCreated()
}
