package pl.edutainment.LessonManager;

import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import org.joda.time.*;

public class Student {

	private int studentID;
	private String firstName;
	private String lastName;
	private String primaryEmail;
	private String secondaryEmail;
	private String primaryPhone;
	private String secondaryPhone;
	private LocalDate signupDate;

	private Address address;
	
	private Group group; 
	
	private List<Lesson> lessonList = new ArrayList<Lesson>();
	
	public static class Builder
	{
		// Required parameters
		private final int studentID;
		private final String firstName;
		private final String lastName;
		
		// Optional parameters
		private String primaryEmail = null;
		private String secondaryEmail = null;
		private String primaryPhone = null;
		private String secondaryPhone = null;
		private Address address = null;
		private LocalDate signupDate = null;
		
		private Group group = null;
		
		public Builder(int studentID, String firstName, String lastName)
		{
			this.studentID = studentID;
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public Builder primaryEmail(String primaryEmail)
		{ this.primaryEmail = primaryEmail;		 return this; }
		public Builder secondaryEmail(String secondaryEmail)
		{ this.secondaryEmail = secondaryEmail;	 return this; }
		public Builder primaryPhone(String primaryPhone)
		{ this.primaryPhone = primaryPhone;		return this; }
		public Builder secondaryPhone(String secondaryPhone)
		{ this.secondaryPhone = secondaryPhone;		return this; }
		public Builder address(Address address) 
		{ this.address = address; 				return this; }
		public Builder group(Group group)
		{ this.group = group;					return this; }
		public Builder signup(LocalDate signupDate) 
		{ this.signupDate = signupDate;			return this; }
		
		public Student build()
		{
			return new Student(this);
		}
		
	} // end public static class Builder
	
	
	private Student(Builder builder)
	{
		studentID = builder.studentID;
		firstName = builder.firstName;
		lastName = builder.lastName;
		primaryEmail = builder.primaryEmail;
		secondaryEmail = builder.secondaryEmail; 
		primaryPhone = builder.primaryPhone;
		secondaryPhone = builder.secondaryPhone;
		signupDate = builder.signupDate;
		address = builder.address;	
	}
	public void addLesson(Lesson lesson)
	{
		lessonList.add(lesson);
	}
	public void removeLesson(Lesson lesson)
	{
		lessonList.remove(lesson);
	}
	public void setGroup(Group group)
	{
		this.group = group;
	}
	public int getID() { return studentID; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getPrimaryEmail() { return primaryEmail; }
	public String getSecondaryEmail() { return secondaryEmail; }
	public String getPrimaryPhone() { return primaryPhone; }
	public String getSecondaryPhone() { return secondaryPhone; }
	public Address getAddress() {return address;}
	public LocalDate getSignupDate() { return signupDate; }
	
	public String getJTreeString()
	{
		return lastName + ", " + firstName;
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Student information\n");
		sb.append("-------------------\n");
		sb.append(String.format("First name: %s\n", firstName));
		sb.append(String.format("Last name: %s\n", lastName));
		sb.append(String.format("Primary e-mail: %s\n", primaryEmail));
		sb.append(String.format("Secondary e-mail: %s\n", secondaryEmail));
		sb.append(String.format("Primary phone: %s\n", primaryPhone));
		sb.append(String.format("Secondary phone: %s\n", secondaryPhone));
		
		if(group!=null)
			sb.append(group.toString());
		else
			sb.append("Group: null\n");
	
		if(address!=null)
			sb.append(address.toString());
		else
			sb.append("Address: null\n");
		
		return sb.toString();

	}
	
} // end class Student
