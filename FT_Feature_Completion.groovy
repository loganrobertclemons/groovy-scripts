import com.atlassian.jira.bc.issue.search.SearchService
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.jql.parser.JqlQueryParser
import com.atlassian.jira.web.bean.PagerFilter
import com.atlassian.jira.issue.Issue
import java.util.ArrayList


enableCache = {-> false}

def issueManager = ComponentAccessor.getIssueManager()
def customFieldManager = ComponentAccessor.getCustomFieldManager()
def cField = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("FT Target Sprint")

def user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()
def searchService = ComponentAccessor.getComponent(SearchService)
def queryParser = ComponentAccessor.getComponent(JqlQueryParser)
def is = issue.getNumber()
def ret = []

def query = queryParser.parseQuery("project = CWOW AND type = Epic AND \"Parent Link\" = CWOW-${is}")
def search = searchService.search(user, query, PagerFilter.getUnlimitedFilter())

if(search.total >= 1) {
	search.results.each {
        documentIssue ->

    	def issue = issueManager.getIssueObject(documentIssue.id)
    		if(issue.getCustomFieldValue(cField) != null) { ret.add(issue.getCustomFieldValue(cField)) }
	}
} else return null

def set = ret.toSet().sort()
return set.last()
