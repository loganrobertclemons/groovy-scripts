ArrayList sprintList = (ArrayList)getCustomFieldValue("Sprint")
int numSprints = (sprintList != null) ? sprintList.size() : 0;

return (numSprints > 0) ? sprintList.get(numSprints - 1).getName() : ""
