package pl.edutainment.LessonManager;

import java.util.ArrayList;
import java.util.List;

public enum GroupList {
	INSTANCE;

	private List<Group> groupList = new ArrayList<Group>();

	
	public List<Group> getList()
	{
		return groupList;
	}
	public boolean addGroup(Group g)
	{ return groupList.add(g); }
	
	public boolean removeGroup(Group g)
	{ 
		if(groupList.contains(g))
			return groupList.remove(g);
		else
			return false;
	}
	public Group getGroup(int groupID)
	{
		for(Group g: groupList)
		{
			if(g.getGroupID() == groupID)
				return g;
		}
		return null;
	}
	public void printGroups()
	{
		System.out.println("Group List");
		System.out.println("----------");
		
		for(Group g: groupList)
		{
			System.out.println(g);
		}
	}
	public void updateList()
	{
		/* Call to database here to retrieve new records */
	}
}
