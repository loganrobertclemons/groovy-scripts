import com.atlassian.jira.component.ComponentAccessor
def changeHistoryManager = com.atlassian.jira.component.ComponentAccessor.getChangeHistoryManager()
def old = changeHistoryManager.getChangeItemsForField(issue, 'FT Target Sprint')
return old?.last().fromString
