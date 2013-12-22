package pl.edutainment.LessonManager;

import java.util.ArrayList;
import java.util.List;

enum ContractList {
	INSTANCE;

	private List<Contract> contractList = new ArrayList<Contract>();

	private ContractList()
	{
		Address address = new Address("Bialolecka 233", "Warszawa", "03-289", "Mazowieckie", "Poland");
		
		for(Company c: CompanyList.INSTANCE.getList())
		{
			Contract contract = new CompanyContract(c);
			contractList.add(contract);
		}
	}
	public List<Contract> getList()
	{
		return contractList;
	}
	public boolean addContract(Contract s)
	{ return contractList.add(s); }
	
	public boolean removeContract(Contract s)
	{ 
		if(contractList.contains(s))
			return contractList.remove(s);
		else
			return false;
	}
	public void printContracts()
	{
		System.out.println("Contract List");
		System.out.println("-------------");
		
		for(Contract c: contractList)
		{
			System.out.println(" | " + "Contract No. " + c.getContractID() + " | " );
			
				Group g = c.getGroup();
				if(g != null)
				{
					System.out.println(g.toString());
				}
				else
				{
					
				}
		}
		
	}
	public void updateList()
	{
		/* Call to database here to retrieve new records */
	}
}

