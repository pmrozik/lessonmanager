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
	
		tree.getModel().addTreeModelListener(new CustomTreeModelListener());
		tree.getModel().addTreeModelListener(new MyTreeModelListener());
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
	class CustomTreeModelListener implements TreeModelListener
	{
		public void treeNodesChanged(TreeModelEvent tme)
		{
			System.out.println("This changed:");
			System.out.println(tme.getSource().toString());
		}
		public void treeNodesInserted(TreeModelEvent tme)	
		{}
		public void treeNodesRemoved(TreeModelEvent tme)	
		{}
		public void treeStructureChanged(TreeModelEvent tme)	
		{}
	}
	class MyTreeModelListener implements TreeModelListener {
	    public void treeNodesChanged(TreeModelEvent e) {
	        DefaultMutableTreeNode node;
	        node = (DefaultMutableTreeNode)
	                 (e.getTreePath().getLastPathComponent());

	        /*
	         * If the event lists children, then the changed
	         * node is the child of the node we have already
	         * gotten.  Otherwise, the changed node and the
	         * specified node are the same.
	         */
	        try {
	            int index = e.getChildIndices()[0];
	            node = (DefaultMutableTreeNode)
	                   (node.getChildAt(index));
	        } catch (NullPointerException exc) {}

	        System.out.println("The user has finished editing the node.");
	        System.out.println("New value: " + node.getUserObject());
	    }
	    public void treeNodesInserted(TreeModelEvent e) {
	    	
	    	System.out.println("Tree nodes inserted.");
	    }
	    public void treeNodesRemoved(TreeModelEvent e) {
	    	System.out.println("Tree nodes removed.");
	    }
	    public void treeStructureChanged(TreeModelEvent e) {
	    	System.out.println("Tree nodes changed.");
	    }
	}

	
}
