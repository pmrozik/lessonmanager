package pl.edutainment.LessonManager;

import java.util.List;

class IndividualContract extends Contract {

	Student contractSigner;
	List<Student> studentList;

	IndividualContract(Student contractSigner)
	{
		this.contractSigner = contractSigner;
	}
	
	public void addStudent(Student student)
	{
		studentList.add(student);
	}
	public void removeStudent(Student student)
	{
		studentList.remove(student);
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Contract signer\n");
		sb.append("---------------\n");
		sb.append(contractSigner.getFirstName() + " " + contractSigner.getLastName() + "\n");
		
		sb.append(super.toString());
		
		return sb.toString();
	}
}
