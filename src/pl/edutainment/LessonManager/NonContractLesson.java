package pl.edutainment.LessonManager;

import java.util.*;

public class NonContractLesson extends Lesson {

		private Price price;
		
		NonContractLesson(Student student, Price price)
		{
			this.setStudent(student);
			this.price = price;	
		}
		NonContractLesson(Group group, Price price)
		{
			setGroup(group);
			this.price = price;
		}
				
		// Getters
		public Price getPrice() { return price; }

		// Setters
		public void setPrice(Price price) { this.price = price; }

}
