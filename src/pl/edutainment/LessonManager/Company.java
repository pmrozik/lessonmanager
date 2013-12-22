package pl.edutainment.LessonManager;

class Company {

	private int companyID;
	private String name;
	private Address address;
	
	public Company(int companyID, String name, Address address) 
	{
		this.companyID = companyID;
		this.name = name;
		this.address = address;
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
		sb.append("Company Information\n");
		sb.append(String.format("ID:  %d\n", companyID));
		sb.append(String.format("Name: %s\n", name));
	
		sb.append(address);
		
		return sb.toString();
		
	}

}


