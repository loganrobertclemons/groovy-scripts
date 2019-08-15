import com.atlassian.jira.bc.issue.search.SearchService
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.jql.parser.JqlQueryParser
import com.atlassian.jira.web.bean.PagerFilter
import com.atlassian.jira.issue.Issue;

def issueManager = ComponentAccessor.getIssueManager()

def user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()
def searchService = ComponentAccessor.getComponent(SearchService)
def queryParser = ComponentAccessor.getComponent(JqlQueryParser)
def is = issue.getNumber()
def testsEpic

if(issue.getIssueType().name == "Test Case"){
    def query = queryParser.parseQuery("project = ATLAS and type = Epic and issueFunction in linkedIssuesOf('key = ATLAS-${is}', 'tests')")
	def search = searchService.search(user, query, PagerFilter.getUnlimitedFilter())

    if(search.total >= 1) {
		search.results.each {
        	issue -> testsEpic = issueManager.getIssueObject(issue.id)
        }
	} else return "ERROR: search.total error"
} else return "ERROR: getIssueType() error"

return "<a href=\"https://jira.davita.com/browse/${testsEpic}\">${testsEpic.summary}</a>"
