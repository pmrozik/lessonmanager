package pl.edutainment.LessonManager;

public class CompanyContract extends Contract {

	private Company company;
	
	public CompanyContract(Company company) {
		this.company = company;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder(company.toString());
		sb.append(super.toString());

		return sb.toString();
	}
}
