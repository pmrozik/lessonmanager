package pl.edutainment.LessonManager.View;

import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import com.toedter.calendar.*;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;
import org.apache.commons.validator.routines.EmailValidator;

import pl.edutainment.LessonManager.GroupList;
import pl.edutainment.LessonManager.Group;
import pl.edutainment.LessonManager.StudentList;
import pl.edutainment.LessonManager.Student;

public class NewStudentFrame extends JFrame {

	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField streetAddressTextField;
	private JTextField cityTextField;
	private JTextField postalCodeTextField;
	private JTextField primaryEmailTextField;
	private JTextField secondaryEmailTextField;
	private JTextField primaryPhoneTextField;
	private JTextField secondaryPhoneTextField;
	private JComboBox<String> countryComboBox;
	private JComboBox<Group> groupComboBox;
	private JDateChooser signupDateChooser;
			
	JButton btnSave;
	JButton btnEdit;

	private Map<String, JTextField> textFieldMap = new HashMap<String, JTextField>();
	List<JTextField> lstChangedFields = new ArrayList<JTextField>();

	public NewStudentFrame() 
	{
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
		
		
		signupDateChooser = new JDateChooser();
		signupDateChooser.setDate(Calendar.getInstance().getTime());
		// signupDateChooser.getDateEditor().addPropertyChangeListener(new DateChooserPropertyListener());
		
		signupDateChooser.setRequestFocusEnabled(false);
		
		add(signupDateChooser, "cell 4 5,growx");
		
		/*signupDateTextField = new JTextField();
		signupDateChooser = new JDateChooser(new JCalendar());
		add(signupDateChooser, "cell 4 5,growx");
		signupDateTextField.setColumns(15);
		*/ 
		
		JLabel lblCountry = new JLabel("Country");
		add(lblCountry, "cell 0 6,alignx left");
		
		System.out.println("Country: " + Locale.getDefault().getDisplayCountry());
		
		countryComboBox = new JComboBox<String>(getCountrySet().toArray(new String[0]));
		countryComboBox.setPrototypeDisplayValue("United Arab Emirates");
		countryComboBox.insertItemAt("", 0);
		countryComboBox.setSelectedIndex(0);
		
		add(countryComboBox, "cell 1 6, alignx left");
		
		JLabel lblGroup = new JLabel("Group");
		add(lblGroup, "cell 3 6, alignx left");
		
		List<Group> groupList = GroupList.INSTANCE.getList();
		Collections.sort(groupList);
		
		Group[] groups = groupList.toArray(new Group[0]);
		groupComboBox = new JComboBox<Group>(groups);
		groupComboBox.setPrototypeDisplayValue(new Group(0,"United Arab Emirates"));
		groupComboBox.insertItemAt(new Group(0,"Not In Group"), 0);
		groupComboBox.setSelectedIndex(0);
		
		add(groupComboBox, "cell 4 6, alignx left");
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(5, 5));
		add(rigidArea_1, "cell 0 7");
		
			
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 8 5 1,growx");
		
		
		btnSave = new JButton("Save");

		add(btnSave, "cell 1 10,alignx right");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewStudentFrame.this.dispose();
			}
		});
		add(btnCancel, "cell 3 10,alignx left");
		
		TitledBorder tBorder = BorderFactory.createTitledBorder("New Student");
		tBorder.setTitleFont(new Font("Serif", Font.BOLD, 14));
		tBorder.setTitleColor(Color.DARK_GRAY);
		tBorder.setTitleJustification(TitledBorder.RIGHT);
		
		// this.setBorder(tBorder);
	
		//Component rigidArea_2 = Box.createRigidArea(new Dimension(5, 5));
		//add(rigidArea_2, "cell 0 11");
		
		
		this.setTitle("New Student");
		this.pack();
		this.setLocationRelativeTo(null);
		setVisible(true);
		
		/*addFieldsToMap();
		
		setEditableFields(false);
		setFieldNames();
		// addChangeListeners();
		btnEdit.addActionListener(new SingleClickActionListener());
		*/
			
	}
	private SortedSet<String> getCountrySet()
	{
		String[] locales = Locale.getISOCountries();
		SortedSet<String> countrySet = new TreeSet<String>();
		
		for (String countryCode : locales) {
	 
			Locale obj = new Locale("", countryCode);
			countrySet.add(obj.getDisplayCountry());

		}
	 
		return countrySet;
		
	}
	public void addSaveButtonListener(ActionListener a)
	{
		btnSave.addActionListener(a);
	}
	public boolean validateFields()
	{
		if(firstNameTextField.getText().isEmpty())
		{
			String msg = "First name is missing!";
			validationMessage(msg);
			firstNameTextField.grabFocus();
			return false;
		}
		else if(lastNameTextField.getText().isEmpty())
		{
			String msg = "Last name is missing!";
			validationMessage(msg);
			lastNameTextField.grabFocus();
			return false;
		}
		else if(primaryEmailTextField.getText().isEmpty())
		{
			String msg = "E-mail is missing!";
			validationMessage(msg);
			primaryEmailTextField.grabFocus();
			return false;
		}
		
		// Validate e-mail address
		
		EmailValidator ev = EmailValidator.getInstance();
		
		if(!ev.isValid(primaryEmailTextField.getText()))
		{
			String msg = "Invalid e-mail address!";
			validationMessage(msg);
			primaryEmailTextField.grabFocus();
			primaryEmailTextField.selectAll();
			return false;
		}
		// Check whether e-mail is already in database
		String primaryEmail = primaryEmailTextField.getText();
		String secondaryEmail = secondaryEmailTextField.getText();
		
		
		
		for(Student student : StudentList.INSTANCE.getList())
		{
			if(primaryEmail.equalsIgnoreCase(student.getPrimaryEmail()))
			{
				String msg = "E-mail address already in database!";
				validationMessage(msg);
				primaryEmailTextField.grabFocus();
				primaryEmailTextField.selectAll();
				return false;
			}
			else if(!secondaryEmail.isEmpty() && secondaryEmail.equalsIgnoreCase(student.getSecondaryEmail()))
			{
				String msg = "E-mail address already in database!";
				validationMessage(msg);
				secondaryEmailTextField.grabFocus();
				secondaryEmailTextField.selectAll();
				return false;
			}
		}
		
		// All required fields filled in
		return true;
	}
	private void validationMessage(String msg)
	{
		JOptionPane.showMessageDialog(this, msg, "Missing value", JOptionPane.ERROR_MESSAGE);
	}
	public String getFirstName() 
	{ 
		return firstNameTextField.getText(); 
	}
	public String getLastName() 
	{ 
		return lastNameTextField.getText(); 
	}
	public String getStreetAddress() 
	{ 
		return streetAddressTextField.getText(); 
	}
	public String getPostalCode() 
	{ 
		return postalCodeTextField.getText(); 
	}
	public String getCity() 
	{ 
		return cityTextField.getText(); 
	}
	public String getPrimaryEmail() 
	{ 
		return primaryEmailTextField.getText(); 
	}
	public String getSecondaryEmail() 
	{ 
		return secondaryEmailTextField.getText(); 
	}
	public String getPrimaryPhone() 
	{ 
		return primaryPhoneTextField.getText(); 
	}
	public String getSecondaryPhone() 
	{ 
		return secondaryPhoneTextField.getText(); 
	}
	public String getCountry() 
	{ 
		String country = countryComboBox.getSelectedItem().toString();
		return country.isEmpty() ? null : country; 
	}
	public Group getGroup() 
	{
		Group selectedGroup = (Group) groupComboBox.getSelectedItem();
	
		return selectedGroup.getGroupID()==0 ? null : selectedGroup;
			
	}
	public Date getSignupDate() { return signupDateChooser.getDate(); }
	
}
	
	

