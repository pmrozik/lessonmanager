package pl.edutainment.LessonManager.Entry;

import java.util.ArrayList;
import java.util.List;

public class PhraseEntry extends Entry{

		private void findPhrasals()
		{
			/* The code here will find phrasal verbs
			  based on entry data */
		}
			
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("Phrases\n");
			sb.append(super.toString());
			
			return sb.toString();
			
		}
}
