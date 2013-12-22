package pl.edutainment.LessonManager.View;

import javax.swing.*;
import java.util.*;

public enum TabbedPane {
		STUDENT_PANEL(new JTabbedPane(JTabbedPane.TOP)), ;

		private JTabbedPane jtp;
		
		TabbedPane(JTabbedPane jtp)
		{
			this.jtp = jtp;
		}
		public void updateList()
		{
			/* Call to database here to retrieve new records */
		}
		public JTabbedPane getTabbedPane()
		{
			return jtp;
		}
		public void addTab(String tabName, JPanel jp)
		{
			jtp.addTab(tabName, jp);
		}
}
	
