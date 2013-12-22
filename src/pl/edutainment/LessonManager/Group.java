package pl.edutainment.LessonManager;

import java.util.List;
import java.util.ArrayList;

public class Group {

	private int groupID;
	private String groupName;
	private List<Student> studentList = new ArrayList<Student>();
	private List<Lesson>  lessonList = new ArrayList<Lesson>();
	
	Group(int groupID, String groupName)
	{
		this.groupID = groupID;
		this.groupName = groupName;
		this.studentList = studentList;
	}
	public String getJTreeString()
	{
		return groupName;
	}
	public void addLesson(Lesson lesson)
	{
		lessonList.add(lesson);
	}
	public void addStudentToGroup(Student student)
	{
		studentList.add(student);
	}
	public void removeStudentFromGroup(Student student)
	{
		studentList.remove(student);
	}
	
	// Getters
	public int getGroupID() { return groupID; }
	public String getGroupName() { return groupName; }
	public List<Student> getStudentList() { return studentList; }
	
	// Setters 
	
	public void setGroupName(String groupName)
	{ this.groupName = groupName; }
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(getGroupID() + " | " 
				+ getGroupName() + "\n");
			
			for(Student s: getStudentList())
			{
				sb.append("\t\t" + s.getID() + " "
						+ s.getFirstName() + " " + s.getLastName() +"\n");
			}
	
			return sb.toString();
	}
}
