package pl.edutainment.LessonManager;

import javax.swing.tree.*;
import java.util.*;

public enum StudentList 
{
	INSTANCE;

	private boolean listChanged=false;
	
	private List<Student> studentList = new ArrayList<Student>();
	private Map<Student, DefaultMutableTreeNode> nodeMap = 
			new HashMap<Student,DefaultMutableTreeNode>();

	
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
	public void addNode(Student student, DefaultMutableTreeNode node)
	{
		nodeMap.put(student, node);
	}
	public DefaultMutableTreeNode getNode(Student student)
	{
		return nodeMap.get(student);
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
		Collections.sort(studentList);
		return retVal; 
	}
	public boolean removeStudent(Student s)
	{ 
		if(studentList.contains(s))
		{
			studentList.remove(s);
			Collections.sort(studentList);
			return true;
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
			Collections.sort(studentList);
			return true;
		}
		return false;
	}

}

