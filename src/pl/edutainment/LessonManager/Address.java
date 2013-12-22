package pl.edutainment.LessonManager;

public class Address {

	private String street;
	private String city;
	private String postalCode;
	private String state;
	private String country;
	
	
	public Address(String city,String street, String postalCode, String state, String country) {
	
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
		this.country = country;
	}
	
	// Getters 
	
	public String getStreet() { return street; }
	public String getCity() { return city; }
	public String getPostalCode() { return postalCode; }
	public String getState() { return state; }
	public String getCountry() { return country; }
	
	// Setters

	public void setStreet(String street) { this.street = street; }
	public void setCity(String city) { this.city = city; }
	public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
	public void setState(String state) { this.state = state; }
	public void setCountry(String country) { this.country = country; }
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Address Information\n");
		sb.append(String.format("Street: %s\n", street));
		sb.append(String.format("City: %s\n", city));
		sb.append(String.format("State: %s\n", state));
		sb.append(String.format("Country: %s\n", country));
		
		return sb.toString();
		
	}
	
}
