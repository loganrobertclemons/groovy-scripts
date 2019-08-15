import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import java.text.SimpleDateFormat
import com.atlassian.core.util.DateUtils;

def cf = ComponentAccessor.customFieldManager.getCustomFieldObjects(issue)?.find { it.name == "UAT Start Date" }
def dateValue = (Date) issue.getCustomFieldValue(cf)
def currentTime = new Date().getTime()
def timeDif = dateValue.getTime() - currentTime
if(timeDif > 0){ return DateUtils.getDurationString(Math.round(timeDif / 1000)).substring(0,5) }
return null
