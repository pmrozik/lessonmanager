package pl.edutainment.LessonManager.View;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.*;
import javax.swing.JSeparator;
import javax.swing.*;

public class LessonFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLessondatetextfield;
	private JTextField txtContract;
	private JLabel lblStartTime;
	private JLabel lblEndTime;
	private JTextField txtStarttime;
	private JTextField txtEndtime;

	private JPanel topPanel;
	private JPanel wordPanel;
	private JPanel grammarPanel;
	private JPanel mistakePanel;
	private JPanel phrasePanel;
	private JPanel homeworkPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LessonFrame frame = new LessonFrame();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LessonFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		topPanel = new JPanel();
		wordPanel = new JPanel();
		grammarPanel = new JPanel();
		mistakePanel = new JPanel();
		phrasePanel = new JPanel();
		homeworkPanel = new JPanel();
		
		Border outside = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inside = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		contentPane.setBorder(BorderFactory.createCompoundBorder(outside, inside));
		
		setContentPane(contentPane);
		
		
		contentPane.setLayout(new MigLayout());
		topPanel.setLayout(new MigLayout());
		wordPanel.setLayout(new MigLayout());
		grammarPanel.setLayout(new MigLayout());
		mistakePanel.setLayout(new MigLayout());
		phrasePanel.setLayout(new MigLayout());
		homeworkPanel.setLayout(new MigLayout());
		
		
		
		JLabel lblLessonDate = new JLabel("Lesson date");
		topPanel.add(lblLessonDate, "cell 0 0,alignx trailing");
		
		txtLessondatetextfield = new JTextField();
		txtLessondatetextfield.setText("lessonDateTextField");
		topPanel.add(txtLessondatetextfield, "cell 1 0");
		txtLessondatetextfield.setColumns(10);
		
		lblStartTime = new JLabel("Start time");
		topPanel.add(lblStartTime, "cell 2 0,alignx trailing");
		
		txtStarttime = new JTextField();
		txtStarttime.setText("StartTime");
		topPanel.add(txtStarttime, "cell 3 0,growx");
		txtStarttime.setColumns(10);
		
		JLabel lblContract = new JLabel("Contract");
		topPanel.add(lblContract, "cell 0 1,alignx trailing");
		
		txtContract = new JTextField();
		txtContract.setText("contract");
		topPanel.add(txtContract, "cell 1 1");
		txtContract.setColumns(10);
		
		lblEndTime = new JLabel("End time");
		topPanel.add(lblEndTime, "cell 2 1,alignx trailing");
		
		txtEndtime = new JTextField();
		txtEndtime.setText("EndTime");
		topPanel.add(txtEndtime, "cell 3 1,growx, wrap");
		txtEndtime.setColumns(10);
	
		
		
		contentPane.add(topPanel, "wrap");
		

		Component rigidArea = Box.createRigidArea(new Dimension(5, 5));
		
		JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
		// separator.setAlignmentX(BOTTOM_ALIGNMENT);
		
		JLabel vocabulary = new JLabel("Vocabulary");
		wordPanel.add(rigidArea, "wrap");
		wordPanel.add(vocabulary, "split 2, span");
		wordPanel.add(separator, "span 5, growx, wrap");
		
		YellowLabel lblWord = new YellowLabel("incredible");
		YellowLabel d = new YellowLabel("defiant");
		YellowLabel e = new YellowLabel("broken");
		YellowLabel f = new YellowLabel("green");
				
		wordPanel.add(lblWord);
		wordPanel.add(d);
		wordPanel.add(e);
	
		contentPane.add(wordPanel, "wrap");
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
		JLabel grammar = new JLabel("Grammar");
		grammarPanel.add(rigidArea, "wrap");
		grammarPanel.add(grammar, "split 2, span");
		grammarPanel.add(separator, "span 5, growx, wrap");
		
		 lblWord = new YellowLabel("past perfect");
		 d = new YellowLabel("passive");
		 e = new YellowLabel("present simple");
	
				
		grammarPanel.add(lblWord);
		grammarPanel.add(d);
		grammarPanel.add(e);
		
		contentPane.add(grammarPanel);
	
		
	}
	private void getHorizontalSectionTitle(String title)
	{
	}
}
