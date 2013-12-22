package pl.edutainment.LessonManager;

import java.text.DateFormat;
import java.util.*;

import org.joda.time.*;

public abstract class Contract {

	protected int contractID;
	protected LocalDate startDate;
	protected LocalDate stopDate;
	protected Price totalPrice;
	protected Price amountPaid;
	protected double numberOfLessons;
	protected Minutes singleLessonDuration;
	protected List<Student> studentList = new ArrayList<Student>();
	protected Group group;
	
	
	// Getters
	
	public int getContractID() { return contractID; }
	public LocalDate getStartDate() { return startDate; }
	public LocalDate getStopDate() { return stopDate; }
	public Price getTotalPrice() { return totalPrice; }
	public Price getAmountPaid() { return amountPaid; }
	public double getNumberOfLessons() { return numberOfLessons; }
	public Minutes getLessonDuration() { return singleLessonDuration; }
	public List<Student> getStudentList() { return studentList; }
	public Group getGroup() { return group; }
		
	// Setters
	
	private void setContractID(int contractID) { /*Get value from database*/  }
	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
	public void setStopDate(LocalDate stopDate ) { this.stopDate = stopDate; }
	public void setTotalPrice (Price totalPrice ) { this.totalPrice = totalPrice; }
	public void setAmountPaid (Price amountPaid ) { this.amountPaid = amountPaid; }
	public void setNumberOfLessons(double numberOfLessons) { this.numberOfLessons = numberOfLessons; }
	public void setGroup(Group group) { this.group = group; }
	public void setStudentList(List<Student> studentList) { this.studentList = studentList; }
	
	/* Some people believe that a single lesson is 45 minutes, others consider it
	 * it to be 60 minutes, so users have a chance to set the duration
	 * when drafting a contract. */
	
	public void setLessonDuration(Minutes singleLessonDuration) { this.singleLessonDuration = singleLessonDuration; }
		
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\nContract information\n");
		sb.append("---------------------\n");
	
		
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String startString = dateFormatter.format(startDate.toDate());
		String endString = dateFormatter.format(stopDate.toDate());
	
		sb.append(String.format("Start date: %s\n", startString));
		sb.append(String.format("End date: %s\n", endString));
		sb.append(String.format("Lesson duration: %d minutes\n", singleLessonDuration.getMinutes() ));
		sb.append(String.format("Number of lessons: %.1f\n", numberOfLessons));
		sb.append(String.format("Total price: %s", totalPrice));
		sb.append(String.format("Amount paid: %s", amountPaid) + "\n");
	
		return sb.toString();
	}
	
}
