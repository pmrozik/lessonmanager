package pl.edutainment.LessonManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ca.odell.glazedlists.*;
import ca.odell.glazedlists.event.ListEventListener;
import ca.odell.glazedlists.swing.*;

public enum GlazedStudentList {
	INSTANCE;

	private EventList<Student> studentList = new BasicEventList<Student>();

	GlazedStudentList()
	{
		
	}
	public boolean addStudent(Student s)
	{ 
		boolean retVal = studentList.add(s);
	
		return retVal; 
	}
	public void addGlazedListener(ListEventListener<Student> lel)
	{
		studentList.addListEventListener(lel);
	}

	
}
