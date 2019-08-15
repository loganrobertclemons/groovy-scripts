import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.history.ChangeItemBean
import com.atlassian.core.util.DateUtils

def changeHistoryManager = ComponentAccessor.getChangeHistoryManager()

def inProgressName = "In Development"

List<Long> rt = [0L]
def changeItems = changeHistoryManager.getChangeItemsForField(issue, "status")
changeItems.reverse().each {ChangeItemBean item ->
    item.toString == inProgressName

    def timeDiff = System.currentTimeMillis() - item.created.getTime()
    if (item.fromString == inProgressName) {
        rt << -timeDiff
    }
    if (item.toString == inProgressName){
        rt << timeDiff
    }
}

def total = rt as int []
return DateUtils.getDurationString(Math.round(total.sum() / 1000))
