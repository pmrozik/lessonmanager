// This class was made to override the convertValueToText(...)
// method to facilitate the labeling of tree nodes

package pl.edutainment.LessonManager;

import javax.swing.JTree;
import javax.swing.tree.*;

public class CustomJTree extends JTree {

	public CustomJTree(DefaultMutableTreeNode dft)
	{
		super(dft);
		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
	}
	public CustomJTree(DefaultTreeModel dtm)
	{
		super(dtm);
		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	}
	public String convertValueToText(Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		
		if(value instanceof DefaultMutableTreeNode)
		{
			DefaultMutableTreeNode dft = (DefaultMutableTreeNode) value;
			Object obj = dft.getUserObject();
			
			if(obj instanceof Student)
			{
				Student s = (Student) obj;
				return s.getJTreeString();
			}
			else if(obj instanceof Group)
			{
				Group g = (Group) obj;
				return g.getJTreeString();
			}	
		}
		
		return super.convertValueToText(value, selected, expanded, leaf, row, hasFocus);
	}
}
