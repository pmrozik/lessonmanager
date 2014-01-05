package pl.edutainment.LessonManager;
import java.util.EventObject;

import ca.odell.glazedlists.*;
import ca.odell.glazedlists.swing.*;
import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TransformedList;




public class GlazedTester {

	GlazedTester()
	{
		GlazedStudentList.INSTANCE.addGlazedListener(new CustomListEventListener());
		DerbyDB.INSTANCE.values();
	}
	public static void main(String[] args)
	{
	
		new GlazedTester();
		
	}
	
	class CustomListEventListener implements ListEventListener<Student>
	{
		public void listChanged(ListEvent<Student> listChanges)
		{
	
			BasicEventList bel = (BasicEventList) listChanges.getSource();
			System.out.println(bel.toString());
			
		}
		
	}
	
	
}
