package pl.edutainment.LessonManager;

public class Company 
{

	private int companyID;
	private String name;
	private Address address;
	
	public Company(int companyID, String name, Address address) 
	{
		this.companyID = companyID;
		this.name = name;
		this.address = address;
	}
	public Company(int companyID, String name)
	{
		this.companyID = companyID;
		this.name = name;
	}

	// Getters
	
	public int getCompanyID() { return companyID; }
	public String getCompanyName() { return name; }
	public Address getCompanyAddress() { return address; }

	// Setters
	
	public void setCompanyName(String name) { this.name = name; }
	public void setCompanyAddress(Address address) { this.address = address; }

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%d | ", companyID));
		sb.append(String.format("%s", name));
	
		return sb.toString();
		
	}

}


