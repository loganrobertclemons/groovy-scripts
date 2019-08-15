import com.atlassian.core.util.DateUtils

DateUtils.getDurationString(((new Date().getTime() - issue.getCreated().time) / (1000)) as Long)
