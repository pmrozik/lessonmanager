package pl.edutainment.LessonManager.Entry;

import java.util.List;
import java.util.ArrayList;

public class GrammarEntry extends Entry {


	private List<String> keywords = new ArrayList<String>();
	

	private void generateKeywords()
	{
		/* The code here will generate keywords based on
		  entry data */
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Grammar\n");
		sb.append(super.toString());
		
		return sb.toString();
		
	}
}
