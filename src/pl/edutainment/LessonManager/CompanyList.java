package pl.edutainment.LessonManager;

import java.util.ArrayList;
import java.util.List;

enum CompanyList {
	INSTANCE;

	private List<Company> companyList = new ArrayList<Company>();

	private CompanyList()
	{
		Address address = new Address("Bialolecka 233", "Warszawa", "03-289", "Mazowieckie", "Poland");
		
		Company company = new Company(1, "Inter Team", address);
	    
		companyList.add(company);
		
	}
	public List<Company> getList()
	{
		return companyList;
	}
	public boolean addCompany(Company s)
	{ return companyList.add(s); }
	
	public boolean removeCompany(Company s)
	{ 
		if(companyList.contains(s))
			return companyList.remove(s);
		else
			return false;
	}
	public void updateList()
	{
		/* Call to database here to retrieve new records */
	}
}

