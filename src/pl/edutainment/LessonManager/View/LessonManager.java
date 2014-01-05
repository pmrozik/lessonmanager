package pl.edutainment.LessonManager.View;
import java.awt.EventQueue;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeSelectionListener;

import pl.edutainment.LessonManager.Controller.*;

public class LessonManager {

	private JFrame frmLessonManagerBy;
	private JScrollPane scrollPane;
	private JTree tree;
	
	private JTabbedPane jtpStudent;
		
	private JTabbedPane jtpGroup;
	private JTabbedPane jtpContracts;
	private JTabbedPane jtpReports;
	
	private Map<String, JTabbedPane> jtpMap = new HashMap<String, JTabbedPane>();

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
	
					try {
			            // Set System L&F
			        UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
			    } 
			    catch (UnsupportedLookAndFeelException e) {
			       // handle exception
			    }
			    catch (ClassNotFoundException e) {
			       // handle exception
			    }
			    catch (InstantiationException e) {
			       // handle exception
			    }
			    catch (IllegalAccessException e) {
			       // handle exception
			    }
					// window.frame.getContentPane().add(new StudentInfo());
					frmLessonManagerBy.pack();
					frmLessonManagerBy.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LessonManager(JTree tree) {
		
	
		this.tree = tree;
		makeTabbedPanes();
		initialize();
		main();
		
	}
	public LessonManager()
	{
		makeTabbedPanes();
		initialize();
		main();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setTree(JTree tree)
	{
		this.tree = tree;
		scrollPane.setRowHeaderView(tree);
		frmLessonManagerBy.pack();
	}
	public Map<String, JTabbedPane> getTabbedPaneMap()
	{
		return jtpMap;
	}
	private void makeTabbedPanes()
	{
		// Student Tabbed Pane
		jtpStudent = new JTabbedPane();
		jtpStudent.setName("jtpStudent"); 
			
		jtpStudent.addTab("Info", new StudentInfoPanel());
		jtpStudent.addTab("Lessons", new LessonPanel());
		jtpStudent.addTab("Finances", new JPanel());
		
		jtpMap.put(jtpStudent.getName(), jtpStudent);
		
		
		jtpGroup = new JTabbedPane();
		jtpGroup.setName("jtpGroup");
		jtpGroup.addTab("gInfo", new JPanel());
		jtpGroup.addTab("gLessons", new JPanel());
		jtpGroup.addTab("gFinances", new JPanel());
		
		jtpMap.put(jtpGroup.getName(), jtpGroup);
		
		
	}
	public void setViewPortView(String tabbedPaneName)
	{
		scrollPane.setViewportView(jtpMap.get(tabbedPaneName));
	}
	public JTabbedPane getTabbedPane(String tabbedPaneName)
	{
		return jtpMap.get(tabbedPaneName);
	}
	public void addTreeSelectionListener(TreeSelectionListener tsl)
	{
		tree.addTreeSelectionListener(tsl);
	}

	private void initialize() {
		frmLessonManagerBy = new JFrame();
		frmLessonManagerBy.setTitle("Lesson Manager by Edutainment");
		frmLessonManagerBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLessonManagerBy.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		frmLessonManagerBy.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	    scrollPane = new JScrollPane();
		frmLessonManagerBy.getContentPane().add(scrollPane, "cell 0 0,grow");
		

		scrollPane.setViewportView(jtpStudent);
		
		scrollPane.setRowHeaderView(tree);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmLessonManagerBy.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JMenu mnContract = new JMenu("Contract");
		mnNew.add(mnContract);
		
		JMenuItem mntmCompanyContract = new JMenuItem("Company Contract");
		JMenuItem mntmPrivateContract = new JMenuItem("Private Contract");
		
		mnContract.add(mntmCompanyContract);
		mnContract.add(mntmPrivateContract);
		
		
		mntmCompanyContract.addActionListener(
	            new ActionListener() 
		    {
	                public void actionPerformed(ActionEvent e) 
			{
	                    
	                	new NewCompanyContractFrameController();
	                }
	            }
	        );
		
		JMenuItem mntmGroup = new JMenuItem("Group");
		mnNew.add(mntmGroup);
		
		JMenuItem mntmStudent = new JMenuItem("Student");
		mnNew.add(mntmStudent);
		mntmStudent.addActionListener(
	            new ActionListener() 
		    {
	                public void actionPerformed(ActionEvent e) {
	                    
	                	new NewStudentFrameController();
	                }
	            }
	        );
		
		JMenuItem mntmlesson = new JMenuItem("Lesson");
		mnNew.add(mntmlesson);
		mntmlesson.addActionListener(
	            new ActionListener() 
		    {
	                public void actionPerformed(ActionEvent e) 
			{
	                    
	                	new LessonFrameController();
	                }
	            }
	        );
		
	}

}
