package pl.edutainment.LessonManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum StudentList {
	INSTANCE;

	private boolean listChanged=false;
	
	private List<Student> studentList = new ArrayList<Student>();

	private StudentList()
	{
	}
	public Student getStudent(int studentID)
	{
		Student tmpStudent = null;
		for(Student student:studentList)
		{
			if(student.getID()==studentID)
			{
				return student;
			}
		}
		return tmpStudent;
	}
	public void setListChanged(boolean listChanged)
	{
		this.listChanged = listChanged;
	}
	public boolean isListChanged()
	{
		return listChanged;
	}
	public List<Student> getList()
	{
		return studentList;
	}
	public boolean addStudent(Student s)
	{ 
		boolean retVal = studentList.add(s);
		return retVal; 
	}
	public boolean removeStudent(Student s)
	{ 
		if(studentList.contains(s))
		{
			return studentList.remove(s);
		}
		else
		{
			return false;
		}
		
	}
	public boolean updateStudent(Student oldStudent, Student newStudent)
	{
		int locIndex = studentList.indexOf(oldStudent);
		if(locIndex >= 0)
		{
			studentList.set(locIndex, newStudent);
			listChanged = true;
			return true;
		}
		return false;
	}

}

