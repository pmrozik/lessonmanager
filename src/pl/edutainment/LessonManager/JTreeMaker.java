package pl.edutainment.LessonManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

abstract public class JTreeMaker {

	public static JTree makeTree()
	{
			JTree tree;
	
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Lesson Manager");
			DefaultMutableTreeNode studentMainNode = new DefaultMutableTreeNode("Students");
			DefaultMutableTreeNode groupMainNode = new DefaultMutableTreeNode("Groups");
			
			// Retrieve student list
			for(Student student : StudentList.INSTANCE.getList())
			{
				
				DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode(student);
				
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
			
			tree = new CustomJTree(root);
			tree.setSelectionRow(1);
	
			return tree;
		
	}
	
}
