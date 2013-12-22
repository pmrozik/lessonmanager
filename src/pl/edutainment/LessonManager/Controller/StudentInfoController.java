package pl.edutainment.LessonManager.Controller;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;


import pl.edutainment.LessonManager.*;
import pl.edutainment.LessonManager.View.*;

public class StudentInfoController {

	Student student;
	StudentInfoPanel pnlStudentInfo;
	
	StudentInfoController(Student student, StudentInfoPanel pnlStudentInfo)
	{
		this.student = student;
		this.pnlStudentInfo = pnlStudentInfo;
		pnlStudentInfo.addSaveButtonListener(new SaveButtonListener());
		
		
		
		update();
	}
	private void setBottomPanelInfo()
	{
		
		
	}
	public void setStudent(Student student)
	{
		this.student=student;
		update();
	}
	public void update()
	{
	
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		String primaryEmail = student.getPrimaryEmail();
		String secondaryEmail = student.getSecondaryEmail();
		String primaryPhone = student.getPrimaryPhone();
		String secondaryPhone = student.getSecondaryPhone();
		String streetAddress = student.getAddress().getStreet();
		String city = student.getAddress().getCity();
		String postalCode = student.getAddress().getPostalCode();
		String signupDate = null;
		
		if(student.getSignupDate()!=null)
		{ 
			signupDate = student.getSignupDate().toString();
		}
			
		
		pnlStudentInfo.setAllTextFields(firstName, lastName,primaryEmail,secondaryEmail,
				primaryPhone,secondaryPhone,streetAddress,city,postalCode,signupDate);
		
		int totalLessons = DerbyDB.INSTANCE.getTotalLessons(student.getID());
		
		pnlStudentInfo.setTotalLessons(totalLessons);
	}

	class SaveButtonListener implements ActionListener
	{
		Map<String,JTextField> tfm;
		
		public void actionPerformed(ActionEvent evt)
		{
			
			System.out.println("Save button clicked! Eureka!");
			checkChangedFields();
		}
		private void checkChangedFields()
		{
			tfm = pnlStudentInfo.getTextFieldMap();
			boolean updated = false;
			
		
			if(!isEqual(student.getFirstName(), tfm.get("firstName").getText()))
			{ 
				String sql = createSQLString(tfm.get("firstName").getName(),tfm.get("firstName").getText()); 
				System.out.println(sql);
				DerbyDB.INSTANCE.update(sql);
				updated = true;
			}
			
		
			
			if(!isEqual(student.getLastName(),tfm.get("lastName").getText()))
			{
				String sql = createSQLString(tfm.get("lastName").getName(),tfm.get("lastName").getText()); 
				System.out.println(sql);
				DerbyDB.INSTANCE.update(sql);
				updated = true;
			}
			if(!isEqual(student.getPrimaryEmail(), tfm.get("primaryEmail").getText()))
			{
				String sql = createSQLString(tfm.get("primaryEmail").getName(),tfm.get("primaryEmail").getText()); 
				System.out.println(sql);
				DerbyDB.INSTANCE.update(sql);
				updated = true;
			}
			if(!isEqual(student.getSecondaryEmail(), tfm.get("secondaryEmail").getText()))
			{
				String sql = createSQLString(tfm.get("secondaryEmail").getName(),tfm.get("secondaryEmail").getText()); 
				System.out.println(sql);
				DerbyDB.INSTANCE.update(sql);
				updated = true;
			}
			if(!isEqual(student.getPrimaryPhone(), tfm.get("primaryPhone").getText()))
			{ 
				String sql = createSQLString(tfm.get("primaryPhone").getName(),tfm.get("primaryPhone").getText()); 
				System.out.println(sql);
				DerbyDB.INSTANCE.update(sql);
				updated = true;
			}
			
			if(!isEqual(student.getSecondaryPhone(), tfm.get("secondaryPhone").getText()))
			{ 
				String sql = createSQLString(tfm.get("secondaryPhone").getName(),tfm.get("secondaryPhone").getText()); 
				System.out.println(sql);
				DerbyDB.INSTANCE.update(sql);
				updated = true;
			}
			Address addr = student.getAddress();
			
			if(!isEqual(addr.getStreet(), tfm.get("streetAddress").getText()))
			{ 
				String sql = createSQLString(tfm.get("streetAddress").getName(),tfm.get("streetAddress").getText()); 
				System.out.println(sql);
				DerbyDB.INSTANCE.update(sql);
				updated = true;
			}
			if(!isEqual(addr.getCity(), tfm.get("city").getText()))
			{ 
				String sql = createSQLString(tfm.get("city").getName(),tfm.get("city").getText()); 
				System.out.println(addr.getCity());
				System.out.println(tfm.get("city").getText());
				System.out.println(sql);
				DerbyDB.INSTANCE.update(sql);
				updated = true;
			}
			if(!isEqual(addr.getPostalCode(), tfm.get("postalCode").getText()))
			{ 
				String sql = createSQLString(tfm.get("postalCode").getName(),tfm.get("postalCode").getText()); 
				System.out.println(sql);
				DerbyDB.INSTANCE.update(sql);
				updated = true;
			}
			if(updated)
			{
				Student updatedStudent = DerbyDB.INSTANCE.getStudent(student.getID());
				StudentList.INSTANCE.updateStudent(student, updatedStudent);
				
	
			}
				
		}
		private boolean isEqual(String orig, String jtxt)
		{
			if(orig == null || orig == null)
			{
				//System.out.println(orig + " = " + jtxt);
				return false;
			}
			else if(orig.equals(jtxt))
			{
				//System.out.println(orig + "=" + jtxt);
				return true;
			
			}
			else
			{
				//System.out.println(orig + "!=" + jtxt);
				return false;
			}
		}
		private String createSQLString(String colName, String value)
		{
			StringBuilder sb = new StringBuilder("UPDATE student\nSET ");
			sb.append(colName + "=\'" + value + "\'\n");
			sb.append("WHERE student_id=" + student.getID());

			return sb.toString();
		}
		
		
	}
}
