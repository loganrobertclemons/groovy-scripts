package com.onresolve.jira.groovy.test.scriptfields.scripts

import com.atlassian.jira.component.ComponentAccessor

def changeHistoryManager = ComponentAccessor.getChangeHistoryManager()
def created = changeHistoryManager.getChangeItemsForField(issue, "status").find {
    it.toString == "Approved"
}?.getCreated()

def createdTime = created?.getTime()

createdTime ? new Date(createdTime) : null
