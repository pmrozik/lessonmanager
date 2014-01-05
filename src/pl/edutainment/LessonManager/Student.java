package pl.edutainment.LessonManager;

import java.sql.Date;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import org.joda.time.*;
import org.joda.time.format.*;

public class Student implements Comparable<Student> {

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
	public int compareTo(Student student2)
	{
		String lastName1 = this.getLastName();
		String lastName2 = student2.getLastName();
		
		int lastNameCompResult = lastName1.compareTo(lastName2);
		
		if(lastNameCompResult > 0)
		{
			return 1;
		}
		else if (lastNameCompResult < 0)
		{
			return -1;
		}
		// Last name the same, compare first names
	
		// Compare first names
		String firstName1 = this.getFirstName();
		String firstName2 = student2.getFirstName();
			
		int firstNameCompResult = firstName1.compareTo(firstName2);
		
		if(firstNameCompResult > 0)
		{
			return 1;
		}
		else if(firstNameCompResult < 0)
		{
			return -1;
		}
		
		// First name and last name the same, compare student IDs
		
		int id1 = this.getID();
		int id2 = student2.getID();
		
		if(id1 > id2)
		{
			return 1;
		}
		if(id1 < id2)
		{
			return -1;
		}
		
		return 0;
		
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
	public int getID() 
	{ 
		return studentID; 
	}
	public String getFirstName() 
	{ 
		return firstName; 
	}
	public String getLastName() 
	{ 
		return lastName; 
	}
	public String getPrimaryEmail() 
	{ 
		return primaryEmail;
       	}
	public String getSecondaryEmail() 
	{ 
		return secondaryEmail; 
	}
	public String getPrimaryPhone() 
	{ 
		return primaryPhone; 
	}
	public String getSecondaryPhone() 
	{ 
		return secondaryPhone; 
	}
	public Address getAddress() 
	{
		return address;
	}
	public LocalDate getSignupDate() 
	{ 
		return signupDate; 
	}
	
	public void setFirstName(String firstName) 
	{ 
		this.firstName = firstName; 
	}
	public void setLastName(String lastName) 
	{  
		this.lastName = lastName; 
	}
	public void setPrimaryEmail(String primaryEmail) 
	{ 
		this.primaryEmail = primaryEmail; 
	}
	public void setSecondaryEmail(String secondaryEmail) 
	{ 
		this.secondaryEmail = secondaryEmail; 
	}
	public void setPrimaryPhone(String primaryPhone) 
	{ 
		this.primaryPhone = primaryPhone; 
	}
	public void setSecondaryPhone(String secondaryPhone) 
	{ 
		this.secondaryPhone = secondaryPhone; 
	}
	public void setAddress(Address address) 
	{
		this.address = address;
	}
	public void setSignupDate(java.util.Date signupDate) 
	{ 
		this.signupDate = LocalDate.fromDateFields(signupDate); 
	}
	
	public String getJTreeString()
	{
		return lastName + ", " + firstName;
	}
	private void appendSingleQuote(StringBuilder sb)
	{
		sb.append("\'");
	}
	private void appendComma(StringBuilder sb)
	{
		sb.append(',');
	}
	public String generateSQLInsert()
	{
			
			StringBuilder fields = new StringBuilder("INSERT INTO student (first_name, last_name");
			StringBuilder values = new StringBuilder(" VALUES (");
			
			appendSingleQuote(values);
			values.append(getFirstName());
			appendSingleQuote(values);
			appendComma(values);
			appendSingleQuote(values);
			values.append(getLastName());
			appendSingleQuote(values);
			
			if(!primaryEmail.isEmpty())
			{
				appendComma(fields);
				fields.append("primary_email");
				appendComma(values);
				appendSingleQuote(values);
				values.append(primaryEmail);
				appendSingleQuote(values);
			}		
			if(!secondaryEmail.isEmpty())
			{
				appendComma(fields);
				fields.append("secondary_email");
				appendComma(values);
				appendSingleQuote(values);
				values.append(secondaryEmail);
				appendSingleQuote(values);
			}
			if(!primaryPhone.isEmpty())
			{
				appendComma(fields);
				fields.append("primary_phone");
				appendComma(values);
				appendSingleQuote(values);
				values.append(primaryPhone);
				appendSingleQuote(values);
			}	
			if(!secondaryPhone.isEmpty())
			{
				appendComma(fields);
				fields.append("secondary_phone");
				appendComma(values);
				appendSingleQuote(values);
				values.append(secondaryPhone);
				appendSingleQuote(values);
			}
			if((address != null) && !(address.getStreet().isEmpty()))
			{
				fields.append(",street_address, city, postal_code, state, country");
				appendComma(values);
				appendSingleQuote(values);
				values.append(address.getStreet());
				appendSingleQuote(values);
				appendComma(values);
				appendSingleQuote(values);
				values.append(address.getCity());
				appendSingleQuote(values);
				appendComma(values);
				appendSingleQuote(values);
				values.append(address.getPostalCode());
				appendSingleQuote(values);
				appendComma(values);
				appendSingleQuote(values);
				values.append(address.getState());
				appendSingleQuote(values);
				appendComma(values);
				appendSingleQuote(values);
				values.append(address.getCountry());
				appendSingleQuote(values);
			}
			if(group != null)
			{
				appendComma(fields);
				fields.append("student_group_fk");
				appendComma(values);
				values.append(group.getGroupID());
			}
			if(signupDate != null)
			{
				String dateString = null;
			
				DateTimeFormatter dayMonthYear = new DateTimeFormatterBuilder().appendYear(4,4)
						.appendLiteral("-")
						.appendMonthOfYear(2)
						.appendLiteral("-")
						.appendDayOfMonth(2)
						.toFormatter();
			
				appendComma(fields);
				fields.append("signup_date");
				appendComma(values);
				appendSingleQuote(values);
				values.append(signupDate.toString(dayMonthYear));
				appendSingleQuote(values);
			}
			
			fields.append(")");
			values.append(")");
			
			return fields.append(values).toString();
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
		sb.append(String.format("Signup date: %s\n", signupDate.toString()));
		
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
