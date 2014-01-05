package pl.edutainment.LessonManager;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.*;

public enum JTreeModel {
	INSTANCE;
	
	private DefaultTreeModel dtModel;

	JTreeModel()
	{
		makeTreeModel();
	}
	public DefaultTreeModel getModel()
	{
		return dtModel;
	}

	private void makeTreeModel()
	{
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Lesson Manager");
		DefaultMutableTreeNode studentMainNode = new DefaultMutableTreeNode("Students");
		DefaultMutableTreeNode groupMainNode = new DefaultMutableTreeNode("Groups");
		
		// Retrieve student list
		for(Student student : StudentList.INSTANCE.getList())
		{
			
			DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode(student);
			StudentList.INSTANCE.addNode(student, studentNode);
			studentMainNode.add(studentNode);
			
		}
		// Retrieve student list
		for(Group group : GroupList.INSTANCE.getList())
		{
					
			DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group);
					
			groupMainNode.add(groupNode);
					
		}
		
		root.add(studentMainNode);
		root.add(groupMainNode);
		dtModel = new DefaultTreeModel(root);
	}
	public void revalidate()
	{
		
	}
}
