package pl.edutainment.LessonManager.View;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class StudentInfoPanel extends JPanel{

	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField streetAddressTextField;
	private JTextField cityTextField;
	private JTextField postalCodeTextField;
	private JTextField primaryEmailTextField;
	private JTextField secondaryEmailTextField;
	private JTextField primaryPhoneTextField;
	private JTextField secondaryPhoneTextField;
	private JTextField signupDateTextField;
	
	private boolean editableFlag;
	
	JLabel lblTotalLessonNumber;
	JLabel lblEditmode;
	JLabel lblOnOff;
	
	JButton btnSave;
	JButton btnEdit;

	private Map<String, JTextField> textFieldMap = new HashMap<String, JTextField>();
	List<JTextField> lstChangedFields = new ArrayList<JTextField>();
	
	/**
	 * Create the panel.
	 */
	public StudentInfoPanel() {
		setLayout(new MigLayout("", "[][pref!,grow][][][grow]", "[][][][][][][][][][][][][]"));
		
		JLabel lblFirstName = new JLabel("First name");
		add(lblFirstName, "cell 0 1,alignx left");
		
		firstNameTextField = new JTextField();
		add(firstNameTextField, "cell 1 1");
		firstNameTextField.setColumns(15);
		
		JLabel lblPrimaryEmail = new JLabel("Primary e-mail");
		add(lblPrimaryEmail, "cell 3 1,alignx left");
		
		primaryEmailTextField = new JTextField();
		add(primaryEmailTextField, "cell 4 1,growx");
		primaryEmailTextField.setColumns(15);
		
		JLabel lblLastName = new JLabel("Last name");
		add(lblLastName, "cell 0 2,alignx left");
		
		lastNameTextField = new JTextField();
		add(lastNameTextField, "cell 1 2,growx");
		lastNameTextField.setColumns(10);
		
		JLabel lblSecondaryEmail = new JLabel("Secondary e-mail");
		add(lblSecondaryEmail, "cell 3 2,alignx left");
		
		secondaryEmailTextField = new JTextField();
		add(secondaryEmailTextField, "cell 4 2,growx");
		secondaryEmailTextField.setColumns(15);
		
		JLabel lblStreetAddress = new JLabel("Street address");
		add(lblStreetAddress, "cell 0 3,alignx trailing");
		
		streetAddressTextField = new JTextField();
		add(streetAddressTextField, "cell 1 3,growx");
		streetAddressTextField.setColumns(10);
		
		JLabel lblPrimaryPhone = new JLabel("Primary phone ");
		add(lblPrimaryPhone, "cell 3 3,alignx left");
		
		primaryPhoneTextField = new JTextField();
		add(primaryPhoneTextField, "cell 4 3,growx");
		primaryPhoneTextField.setColumns(15);
		
		JLabel lblCity = new JLabel("City");
		add(lblCity, "cell 0 4,alignx left");
		
		cityTextField = new JTextField();
		add(cityTextField, "cell 1 4,growx");
		cityTextField.setColumns(10);
		
		JLabel lblSecondaryPhone = new JLabel("Secondary phone");
		add(lblSecondaryPhone, "cell 3 4,alignx left");
		
		secondaryPhoneTextField = new JTextField();
		add(secondaryPhoneTextField, "cell 4 4,growx");
		secondaryPhoneTextField.setColumns(15);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea, "cell 2 0 1 7");
		
		JLabel lblPostalCode = new JLabel("Postal code");
		add(lblPostalCode, "cell 0 5,alignx left");
		
		postalCodeTextField = new JTextField();
		add(postalCodeTextField, "cell 1 5,growx");
		postalCodeTextField.setColumns(10);
		
		JLabel lblSignupDate = new JLabel("Signup date");
		add(lblSignupDate, "cell 3 5,alignx left");
		
		signupDateTextField = new JTextField();
		add(signupDateTextField, "cell 4 5,growx");
		signupDateTextField.setColumns(15);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea_1, "cell 0 6");
		
		btnSave = new JButton("Save");
		add(btnSave, "cell 1 7");
		btnSave.setVisible(false);
		
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 8 5 1,growx");
		
		
		
		JButton btnPrev = new JButton("Prev");
		add(btnPrev, "cell 1 10,alignx right");
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNext, "cell 3 10,alignx left");
		
		TitledBorder tBorder = BorderFactory.createTitledBorder("Student Information");
		tBorder.setTitleFont(new Font("Serif", Font.BOLD, 14));
		tBorder.setTitleColor(Color.DARK_GRAY);
		tBorder.setTitleJustification(TitledBorder.RIGHT);
		
		this.setBorder(tBorder);
		
		btnEdit = new JButton("Edit");
		add(btnEdit, "cell 0 7");
		btnEdit.addActionListener(new EditButtonListener());
		
		lblEditmode = new JLabel("Edit mode is");
		add(lblEditmode, "flowx,cell 4 7,alignx right");
		
		lblOnOff = new JLabel("off");
		lblOnOff.setForeground(Color.RED);
		add(lblOnOff, "cell 4 7");
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea_2, "cell 0 11");
		
		JLabel labelTotalLessons = new JLabel("Total lessons:");
		add(labelTotalLessons, "cell 0 12");
		
		lblTotalLessonNumber = new JLabel("");
		add(lblTotalLessonNumber, "cell 1 12");
	
		
		addFieldsToMap();
		
		setEditableFields(false);
		setFieldNames();
		addChangeListeners();
		btnEdit.addActionListener(new SingleClickActionListener());

			
	}
	public List<JTextField> getChangedFields()
	{

		return lstChangedFields;
	}
	public void setTotalLessons(int totalLessons)
	{
		lblTotalLessonNumber.setText(Integer.toString(totalLessons));
	}
	private void setFieldNames()
	{
		firstNameTextField.setName("first_name");
		lastNameTextField.setName("last_name");
		streetAddressTextField.setName("street_address");
		cityTextField.setName("city");
		postalCodeTextField.setName("postal_code");
		primaryEmailTextField.setName("primary_email");
		secondaryEmailTextField.setName("secondary_email");
		primaryPhoneTextField.setName("primary_phone");
		secondaryPhoneTextField.setName("secondary_phone");
		signupDateTextField.setName("signup_date");
	}
	private void addChangeListeners()
	{
		for(JTextField jtxt: textFieldMap.values())
		{
			jtxt.getDocument().addDocumentListener( new TextFieldChangeListener());
			jtxt.getDocument().putProperty("name", jtxt.getName());
		}
	}
	public Map<String, JTextField> getTextFieldMap()
	{
		return textFieldMap;
	}
	private void addFieldsToMap()
	{
		textFieldMap.put("firstName", firstNameTextField);
		textFieldMap.put("lastName", lastNameTextField);
		textFieldMap.put("streetAddress", streetAddressTextField);
		textFieldMap.put("city", cityTextField);
		textFieldMap.put("postalCode", postalCodeTextField);
		textFieldMap.put("primaryEmail", primaryEmailTextField);
		textFieldMap.put("secondaryEmail", secondaryEmailTextField);
		textFieldMap.put("primaryPhone", primaryPhoneTextField);
		textFieldMap.put("secondaryPhone", secondaryPhoneTextField);
		textFieldMap.put("signupDate", signupDateTextField);	
	}

	public void setAllTextFields(String... args)
	{
		
		 firstNameTextField.setText(args[0]);
		 lastNameTextField.setText(args[1]);
		 primaryEmailTextField.setText(args[2]);
		 secondaryEmailTextField.setText(args[3]);
		 primaryPhoneTextField.setText(args[4]);
		 secondaryPhoneTextField.setText(args[5]);
		 streetAddressTextField.setText(args[6]);
		 cityTextField.setText(args[7]);
		 postalCodeTextField.setText(args[8]);
		 signupDateTextField.setText(args[9]);
		 
	}
	public void addSaveButtonListener(ActionListener alt)
	{
		btnSave.addActionListener(alt);
	}

	private void setEditableFields(boolean editable)
	{
		for(JTextField jtxt: textFieldMap.values())
		{
			if(jtxt != null)
			{
				jtxt.setEditable(editable);
			}
		}
	}
	public void toggleFieldVisibility()
	{
	
		if(editableFlag)
		{
			editableFlag=false;
			System.out.println("First name field is editable.");
			lblOnOff.setText("OFF");
			lblOnOff.setForeground(Color.RED);
			btnSave.setVisible(false);
			setEditableFields(false);
		}
		else
		{
			editableFlag=true;
			System.out.println("Fields not editable");
			lblOnOff.setText("ON");
			lblOnOff.setForeground(Color.GREEN);
			btnSave.setVisible(true);
			setEditableFields(true);
		}
	}
	class SingleClickActionListener extends MouseAdapter implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			
		}
		public void mouseClicked(MouseEvent evt)
		{
			if(evt.getClickCount()==1)
			{
				toggleFieldVisibility();
			}
				
		}
		
	}
	class EditButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			toggleFieldVisibility();
			System.out.println("Clicked Edit Button!");
		}
		
	}
	class TextFieldChangeListener implements DocumentListener
	{
		  public void changedUpdate(DocumentEvent e) {
		    addToList(e);
		  }
		  public void removeUpdate(DocumentEvent e) {
		    addToList(e);
		  }
		  public void insertUpdate(DocumentEvent e) {
		    addToList(e);
		  }
		  
		  private void addToList(DocumentEvent e)
		  {
			  System.out.println(e.getDocument().getProperty("name"));
			  
		  }
		  
	}
	

}
