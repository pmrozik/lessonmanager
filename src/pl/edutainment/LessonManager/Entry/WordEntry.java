package pl.edutainment.LessonManager.Entry;

public class WordEntry extends Entry {

	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Words\n");
		sb.append(super.toString());
		
		return sb.toString();
		
	}
}
