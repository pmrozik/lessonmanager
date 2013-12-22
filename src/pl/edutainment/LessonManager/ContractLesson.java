package pl.edutainment.LessonManager;

public class ContractLesson extends Lesson {

	private Contract contract;
	
	public ContractLesson(Contract contract) {
	
		this.contract = contract;
	}
	public Contract getContract() { return contract; }
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(contract.toString());
		sb.append(super.toString());
		
		return sb.toString();
	}
}
