package pl.edutainment.LessonManager.Controller;
import java.util.Map;

import pl.edutainment.LessonManager.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import pl.edutainment.*;
import pl.edutainment.LessonManager.View.*;
import pl.edutainment.LessonManager.DerbyDB;

public class JTreeController {

	private JTree tree;
	private LessonManager lm;
	private Student selectedStudent;
	
	// Controllers
	StudentInfoController siController;
	
	
	public JTreeController(JTree tree, LessonManager lm)
	{
		this.tree = tree;
		this.lm = lm;
		lm.setTree(tree);
		lm.addTreeSelectionListener(new CustomTreeSelectionListener());
	}
	public void updateJTreeNode(DefaultMutableTreeNode node)
	{
		
	}
	class CustomTreeSelectionListener implements TreeSelectionListener
	{
		
		public void valueChanged(TreeSelectionEvent evt)
		{	
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                     tree.getLastSelectedPathComponent();
			 
			if(node!=null)
			{
				
				Object source = node.getUserObject();
			 
					if(source instanceof Student)
					{
												
						Student student = (Student) source;
						
						if(StudentList.INSTANCE.isListChanged())
						{
							int studentID = student.getID();
							student = StudentList.INSTANCE.getStudent(studentID);
							node.setUserObject(student);
							tree.revalidate();
						}
						
						
						lm.setViewPortView("jtpStudent");
						JTabbedPane jtpActive = lm.getTabbedPane("jtpStudent");
						
						int jtpSelectedIndex = jtpActive.getSelectedIndex();
						
						StudentInfoPanel sip = (StudentInfoPanel)
								jtpActive.getComponentAt(jtpSelectedIndex);
						
						if(siController == null)
						{
							siController = new StudentInfoController(student, sip);
						}
						
						if(selectedStudent == null)
						{
							
							selectedStudent=student;	
							
						}
						else
						{
								siController.setStudent(student);
								siController.update();
						}
					}
					else if(source instanceof Group)
					{
						
						Group group = (Group) source;
						lm.setViewPortView("jtpGroup");
						System.out.println(group);
					}
					
				
			}
			
		} // end valueChanged(...)
	} // end class CustomTreeSelectionListener
}
