package pl.edutainment.LessonManager.Entry;

import java.util.ArrayList;
import java.util.List;

public class AgendaEntry extends Entry {

	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Agenda\n");
		sb.append(super.toString());
		
		return sb.toString();
		
	}
}
