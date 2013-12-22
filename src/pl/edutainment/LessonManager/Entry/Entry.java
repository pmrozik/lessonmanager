package pl.edutainment.LessonManager.Entry;

import java.util.ArrayList;
import java.util.List;

public abstract class Entry {

	private List<String> entry = new ArrayList<String>();
	
	public void add(String s)
	{
		entry.add(s);
	}
	public void remove(String s)
	{
		entry.remove(s);
	}
	public String toString()
	{
		return entry.toString();		
	}
}
