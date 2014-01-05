package pl.edutainment.LessonManager.View;

import javax.swing.*;

import com.toedter.calendar.*;
import org.joda.time.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;

import net.miginfocom.swing.MigLayout;
import pl.edutainment.LessonManager.*;
// import pl.edutainment.util.*;


public class NewCompanyContractFrame extends JFrame{

	private JLabel lblContractDurationResult;
	
	private JTextField priceTextField;
	private JTextField numberOfLessonsTextField;
	private JComboBox companyComboBox;
	private JDateChooser contractStartDateChooser;
	private JDateChooser contractStopDateChooser;
	
	
	JButton btnSave;
	JButton btnCancel;
	
	public NewCompanyContractFrame()
	{
		setTitle("New Company Contract");
		setLayout(new MigLayout());
		createGUI();
		
		pack();
		setVisible(true);
		
	}
	private void createGUI()
	{
		JLabel lblStartDate = new JLabel("Start Date");
		contractStartDateChooser = new JDateChooser();
		
		add(lblStartDate);
		add(contractStartDateChooser, "growx, wrap");
		
	
		JLabel lblStopDate = new JLabel("Stop Date");
		contractStopDateChooser = new JDateChooser();
		
		add(lblStopDate);
		add(contractStopDateChooser, "growx, wrap");
		
		
		JLabel lblPrice = new JLabel("Price");
		priceTextField = new JTextField(15);
		
		add(lblPrice);
		add(priceTextField, "growx, wrap");
		
		JLabel lblNumberOfLessons = new JLabel("No. of Lessons");
		numberOfLessonsTextField = new JTextField(15);
		
		add(lblNumberOfLessons);
		add(numberOfLessonsTextField, "growx, wrap");
		
		JLabel lblCompany = new JLabel("Company");
		companyComboBox = new JComboBox<Company>(CompanyList.INSTANCE.getList().toArray(new Company[0]));
		companyComboBox.setPrototypeDisplayValue(new Company(0,"United Arab Emirates"));
		
		add(lblCompany);
		add(companyComboBox, "growx, wrap");
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(5, 5));
		add(rigidArea_1, "wrap");
		
			
		JSeparator separator = new JSeparator();
		add(separator, "span 2, growx, wrap");
		
		
		btnSave = new JButton("Save");

		add(btnSave, "alignx right");
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCompanyContractFrame.this.dispose();
			}
		});
		add(btnCancel, "alignx left");
		
		this.setLocationRelativeTo(null);
	}
	public boolean isFormValid()
	{
		
		if(contractStartDateChooser.getDate() == null)
		{
			
			validationMessage("Please choose a start date.");
			contractStartDateChooser.grabFocus();
			return false;
		}
		if(contractStopDateChooser.getDate() == null)
		{
			validationMessage("Please choose a stop date.");
			contractStopDateChooser.grabFocus();
			return false;
		}
		
		if(priceTextField.getText().isEmpty())
		{
			
			validationMessage("Please enter a valid price.");
			priceTextField.grabFocus();	
			
			return false;
		}
		else 
		{
			try
			{
				Integer.parseInt(priceTextField.getText());
			}
			catch (NumberFormatException ex)
			{
				validationMessage("Price not valid. Use digits only.");
				priceTextField.grabFocus();
				return false;
			}	
		}
		
		if(numberOfLessonsTextField.getText().isEmpty())
		{
			
			validationMessage("Please enter number of lessons.");
			numberOfLessonsTextField.grabFocus();	
			return false;
		}
		else 
		{
			try
			{
				Integer.parseInt(numberOfLessonsTextField.getText());
			}
			catch (NumberFormatException ex)
			{
				validationMessage("Number of lessons not valid. Use digits only.");
				numberOfLessonsTextField.grabFocus();
				return false;
			}	
		}
		
		
		
		validationMessage(createSummaryMessage());
		
		return true;
	}
	private void validationMessage(String msg)
	{
		JOptionPane.showMessageDialog(this, msg, "Missing value", JOptionPane.ERROR_MESSAGE);
	}
	private String createSummaryMessage()
	{
		StringBuilder sb = new StringBuilder("Create new contract for: " + companyComboBox.getSelectedItem().toString() + "\n");
		
		DateTime start = new DateTime(contractStartDateChooser.getDate());
		DateTime stop = new DateTime(contractStopDateChooser.getDate());
		
		// Days d = Days.daysBetween(start, stop);
		
		Period p = new Period(start, stop);
				
	
		sb.append("Duration: " + p.getYears() + "years, " + p.getMonths()
				+ " months, and" + p.getDays() + " days");
	
		return sb.toString();
		
	}
	public void addSaveButtonListener(ActionListener a)
	{
		btnSave.addActionListener(a);
	}
	
}
