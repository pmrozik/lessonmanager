package pl.edutainment.LessonManager.Entry;

import java.util.ArrayList;
import java.util.List;

public class HomeworkEntry extends Entry {

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Homework\n");
		sb.append(super.toString());
		
		return sb.toString();
		
	}
}
