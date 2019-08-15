import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;

def customFieldManager = ComponentAccessor.getCustomFieldManager();
def epicLink = customFieldManager.getCustomFieldObjectByName('Epic Link');

def parentLink = customFieldManager.getCustomFieldObjectByName('Parent Link');
def epic = issue.getCustomFieldValue(epicLink)

if(epic) { // here we check if the story is connected to an epic
 epic = (Issue)epic

 if(epic.getCustomFieldValue(parentLink)) { // here we check if epic is connected to an parent (via portfolio)
 def parentLinkReference = epic.getCustomFieldValue(parentLink);
 def key =(String)parentLinkReference.getKey();
 def summary =(String)parentLinkReference.getSummary();

 return key.concat(" ").concat(summary)
 }
}
return null
