package pl.edutainment.LessonManager.Controller;
import pl.edutainment.LessonManager.View.*;
import pl.edutainment.LessonManager.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.JOptionPane;

public class NewStudentFrameController {

	NewStudentFrame nsf;
	Student student;
	
	public NewStudentFrameController()
	{
		nsf = new NewStudentFrame();
		nsf.addSaveButtonListener(new SaveButtonListener());
	}
	
	public class SaveButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			// Check whether fields have been filled in correctly
			if (nsf.validateFields())
			{
			
				createStudent();
				addStudentToDB();
			
			}
		}
		private void createStudent()
		{
			int newStudentID = DerbyDB.INSTANCE.getMaxStudentID() + 1;
				
			String firstName = nsf.getFirstName();
			String lastName = nsf.getLastName();
			System.out.println("New student ID is " + newStudentID);
			
			student = new Student.Builder(newStudentID, firstName, lastName).build();
			
			student.setPrimaryEmail(nsf.getPrimaryEmail());
			student.setSecondaryEmail(nsf.getSecondaryEmail());
			student.setPrimaryPhone(nsf.getPrimaryPhone());
			student.setSecondaryPhone(nsf.getSecondaryPhone());
			student.setGroup(nsf.getGroup());
			student.setSignupDate(nsf.getSignupDate());
			
			String streetAddress = nsf.getStreetAddress();
			String city = nsf.getCity();
			String postalCode = nsf.getPostalCode();
			
			Address address = new Address(streetAddress, city, postalCode, "", "");
			address.setCountry(nsf.getCountry());
		
			student.setAddress(address);
			
			System.out.println("Adding the following student...");
			System.out.println(student);
			System.out.println(student.generateSQLInsert());
			
		}
		private void addStudentToDB()
		{
			int retVal = DerbyDB.INSTANCE.update(student.generateSQLInsert());
		
			if(retVal > 0)
			{
				String firstName = student.getFirstName();
				String lastName = student.getLastName();
				JOptionPane.showMessageDialog(nsf, firstName + " " + lastName + " added." );
				nsf.dispose();
			}
		}
		
	}
}
