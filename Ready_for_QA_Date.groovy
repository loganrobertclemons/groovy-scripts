package com.onresolve.jira.groovy.test.scriptfields.scripts

import com.atlassian.jira.component.ComponentAccessor

def changeHistoryManager = ComponentAccessor.getChangeHistoryManager()
def created = changeHistoryManager.getChangeItemsForField(issue, "status").find {
    it.toString == "Ready for QA"
}?.getCreated()

def createdTime = created?.getTime()

createdTime ? new Date(createdTime) : null
