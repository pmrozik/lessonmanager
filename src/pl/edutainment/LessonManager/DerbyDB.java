package pl.edutainment.LessonManager;
import java.sql.*;
import org.joda.time.*;

public enum DerbyDB {
	INSTANCE;
	
	private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private String dbName = "mynewdb";
	private String connectionURL = "jdbc:derby:C:\\Users\\Pablo\\java\\derby\\" + dbName;
	private Connection connection = null;
	Statement statement;
	
	private DerbyDB()
	{
		
		
		try {
            // Create (if needed) and connect to the database
            connection = DriverManager.getConnection(connectionURL);		 
            System.out.println("Connected to database " + dbName);
            
            //   ## INITIAL SQL SECTION ## 
            //   Create a statement to issue simple commands.  
            statement = connection.createStatement();
			
            System.out.print("Executing query...");
			
			
			System.out.println("done.");
			loadStudentList();
			loadGroupList();
			
			
			}  catch (Throwable e)  {   
            /*       Catch all exceptions and pass them to 
            **       the exception reporting method             */
            System.out.println(" . . . exception thrown:");
            System.out.println(e);
         }
		
	}
	public int getTotalLessons(int studentID)
	{
		String selectString = "SELECT COUNT(*) count FROM student_attendance " +
				"WHERE student_fk=" + studentID;
		int returnVal=0;
		try
		{
			ResultSet myResult = statement.executeQuery(selectString);
					
			while (myResult.next())
			{
				returnVal = myResult.getInt("count");
			}
		
			myResult.close();
		}
		catch (SQLException ex) { ex.printStackTrace();} 
		
		return returnVal;
	}
	public Student getStudent(int studentID)
	{
		Student student = null;
		String firstName = null;
		String lastName = null;
		String primaryEmail = null;
		String primaryPhone = null;
		String secondaryEmail = null;
		String secondaryPhone = null;
		String streetAddress = null;
		String city = null;
		String postalCode = null;
		String state = null;
		String country = null;
		LocalDate signupDate = null;
		
		String selectString = "SELECT * FROM student WHERE student_id=" + studentID;
		
		try
		{
			ResultSet myResult = statement.executeQuery(selectString);
			
			while (myResult.next())
			{
				 studentID =  myResult.getInt("student_id");
                 firstName = myResult.getString("first_name");
                 lastName = myResult.getString("last_name");
                 primaryEmail = myResult.getString("primary_email");
                 secondaryEmail = myResult.getString("secondary_email");
                 primaryPhone = myResult.getString("primary_phone");
                 secondaryPhone = myResult.getString("secondary_phone");
                 streetAddress = myResult.getString("street_address");
                 city = myResult.getString("city");
                 postalCode = myResult.getString("postal_code");
                 state = myResult.getString("state");
                 country = myResult.getString("country");
                 Date date = myResult.getDate("signup_date");
                 
                 if(date != null)
                 {
                	 signupDate = LocalDate.fromDateFields(date);
                 }
                 else { signupDate = null; }
                 
                 Address address =
                		 new Address(streetAddress, city, postalCode, state, country);
              
                 student = new Student.Builder(studentID, firstName, lastName).primaryEmail(primaryEmail).
                 secondaryEmail(secondaryEmail).primaryPhone(primaryPhone).secondaryPhone(secondaryPhone).address(address).signup(signupDate).build();
                 
                 
                 
			}
			myResult.close();
		}
		catch (SQLException ex) { ex.printStackTrace();} 
		
		return student;
		
	}
	public void closeConnection()
	{
		try
		{
		statement.close();
		connection.close();
		System.out.println("Closed connection");
		}
		catch (SQLException ex) { ex.printStackTrace(); }
	}
	public void loadStudentList()
	{
		int studentID = 0;
		String firstName = null;
		String lastName = null;
		String primaryEmail = null;
		String primaryPhone = null;
		String secondaryEmail = null;
		String secondaryPhone = null;
		String streetAddress = null;
		String city = null;
		String postalCode = null;
		String state = null;
		String country = null;
		LocalDate signupDate = null;
		
		String selectString = "SELECT * FROM student";
		
		
		try
		{
			ResultSet myResult = statement.executeQuery(selectString);
			
			while (myResult.next())
			{
                     studentID =  myResult.getInt("student_id");
                     firstName = myResult.getString("first_name");
                     lastName = myResult.getString("last_name");
                     primaryEmail = myResult.getString("primary_email");
                     secondaryEmail = myResult.getString("secondary_email");
                     primaryPhone = myResult.getString("primary_phone");
                     secondaryPhone = myResult.getString("secondary_phone");
                     streetAddress = myResult.getString("street_address");
                     city = myResult.getString("city");
                     postalCode = myResult.getString("postal_code");
                     state = myResult.getString("state");
                     country = myResult.getString("country");
                     Date date = myResult.getDate("signup_date");
                     
                     if(date != null)
                     {
                    	 signupDate = LocalDate.fromDateFields(date);
                     }
                     else { signupDate = null; }
                     
                     Address address =
                    		 new Address(streetAddress, city, postalCode, state, country);
                  
                     Student student = new Student.Builder(studentID, firstName, lastName).primaryEmail(primaryEmail).
                     secondaryEmail(secondaryEmail).primaryPhone(primaryPhone).secondaryPhone(secondaryPhone).address(address).signup(signupDate).build();
                     
                     StudentList.INSTANCE.addStudent(student);
                     
			}
			myResult.close();
		}
		catch (SQLException ex) { ex.printStackTrace(); }
	}
	private void loadGroupList()
	{
		int groupID = 0;
		String groupName;
		
		String selectString = "SELECT * FROM student_group";
		
		try
		{
			ResultSet myResult = statement.executeQuery(selectString);
			
			while (myResult.next())
			{
                     groupID =  myResult.getInt("student_group_id");
                     groupName = myResult.getString("name");
                    
                     Group group = new Group(groupID, groupName);
                     
                     GroupList.INSTANCE.addGroup(group);
                     
			}
			
			myResult.close();
		}
		catch (SQLException ex) { ex.printStackTrace(); }
	}
	public void update(String sqlInsert)
	{
		try
		{ 
			statement = connection.createStatement();
			statement.executeUpdate(sqlInsert);
		
		}
		catch (SQLException ex) { ex.printStackTrace(); }
	}
	public Connection getConnection() { return connection; }
}
