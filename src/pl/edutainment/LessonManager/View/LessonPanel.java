package pl.edutainment.LessonManager.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.MigLayout;


public class LessonPanel extends JPanel {

	

	private JTextField txtLessonDate;
	private JTextField txtContract;
	private JLabel lblStartTime;
	private JLabel lblEndTime;
	private JTextField txtStartTime;
	private JTextField txtEndTime;

	private JPanel topPanel = new JPanel(new MigLayout());
	private JPanel wordPanel = new JPanel(new MigLayout("fill, align center, wrap 6"));
	private JPanel agendaPanel = new JPanel(new MigLayout("fill, align center"));
	private JPanel grammarPanel = new JPanel(new MigLayout("fill, align left"));
	private JPanel mistakePanel = new JPanel(new MigLayout("fill, align center"));
	private JPanel phrasePanel = new JPanel(new MigLayout("fill, align left"));
	private JPanel homeworkPanel = new JPanel(new MigLayout("fill, align left"));
	private JPanel lessonListPanel = new JPanel(new MigLayout());
	

	public LessonPanel()
	{
	
		setLayout(new MigLayout());
	
		setupBorders();
		setupTopPanel();
		setupAgendaPanel();
		setupWordPanel();
		setupGrammarPanel();
		setupPhrasePanel();
		setupMistakePanel();
		setupHomeworkPanel();
		// setupLessonListPanel();
		
		this.setVisible(true);
		
	}
	private void setupBorders()
	{
		TitledBorder tBorder = BorderFactory.createTitledBorder("Lesson Browser");
		tBorder.setTitleFont(new Font("Serif", Font.BOLD, 14));
		tBorder.setTitleColor(Color.DARK_GRAY);
		tBorder.setTitleJustification(TitledBorder.RIGHT);
		
		this.setBorder(tBorder);	
	}
	private void setupTopPanel() 
	{
		topPanel.setLayout(new MigLayout("fill"));
		Component rigidArea = Box.createRigidArea(new Dimension(50, 5));
		
		JLabel lblLessonDate = new JLabel("Lesson date");
		topPanel.add(lblLessonDate, "cell 0 0,alignx trailing");
		
		txtLessonDate = new JTextField();
		txtLessonDate.setText("07/02/2013");
		topPanel.add(txtLessonDate, "cell 1 0");
		txtLessonDate.setColumns(10);
		txtLessonDate.setEditable(false);
		
		topPanel.add(rigidArea, "cell 2 0");
		
		lblStartTime = new JLabel("Start time");
		topPanel.add(lblStartTime, "cell 3 0,alignx trailing");
		
		txtStartTime = new JTextField();
		txtStartTime.setText("2:00PM");
		topPanel.add(txtStartTime, "cell 4 0,growx");
		txtStartTime.setColumns(10);
		txtStartTime.setEditable(false);
		
		JLabel lblContract = new JLabel("Contract");
		topPanel.add(lblContract, "cell 0 1,alignx trailing");
		
		txtContract = new JTextField();
		txtContract.setText("B00001");
		topPanel.add(txtContract, "cell 1 1");
		txtContract.setColumns(10);
		txtContract.setEditable(false);
		
		lblEndTime = new JLabel("End time");
		topPanel.add(lblEndTime, "cell 3 1,alignx trailing");
		
		txtEndTime = new JTextField();
		txtEndTime.setText("3:00PM");
		topPanel.add(txtEndTime, "cell 4 1,growx, wrap");
		txtEndTime.setColumns(10);
		txtEndTime.setEditable(false);
	
		this.add(topPanel, "wrap");
		
	}
	private void setupAgendaPanel() 
	{
		SeparatedTitlePanel stp = new SeparatedTitlePanel("Agenda");		
		
		YellowLabel lblNE = new YellowLabel("Natural English p. 128 Ex. 1-4"); 
		YellowLabel lblAD = new YellowLabel("Tha Yella Label");
		agendaPanel.add(lblNE, "growx, align center, wrap");
		agendaPanel.add(lblAD, "growx, align center, wrap");

		this.add(stp, "grow, wrap");
		this.add(agendaPanel, "grow, wrap");
		
	}
	private void setupWordPanel()
	{
		SeparatedTitlePanel stp = new SeparatedTitlePanel("Vocabulary");
		
		YellowLabel lblWord = new YellowLabel("incredible");
		YellowLabel d = new YellowLabel("defiant");
		YellowLabel e = new YellowLabel("broken");
		YellowLabel f = new YellowLabel("green");
		YellowLabel g = new YellowLabel("superfluous");
		
		
		wordPanel.add(lblWord, "growx");
		wordPanel.add(d, "growx");
		wordPanel.add(e, "growx");
		wordPanel.add(f, "growx");
		wordPanel.add(g, "growx");
		wordPanel.add(new YellowLabel("picturesque"), "growx");
		wordPanel.add(new YellowLabel("portrait"), "growx");
		wordPanel.add(new YellowLabel("bounty"), "growx");
		wordPanel.add(new YellowLabel("plentiful"), "growx");
		
		
		
		this.add(stp, "grow, wrap");
		this.add(wordPanel, "grow, wrap");
	}
	private void setupGrammarPanel()
	{
		SeparatedTitlePanel stp = new SeparatedTitlePanel("Grammar");
		
		 JLabel lblWord = new YellowLabel("past perfect");
		 JLabel d = new YellowLabel("passive");
		 JLabel e = new YellowLabel("present simple");
	
				
		 grammarPanel.add(lblWord,"grow, wrap");
		 grammarPanel.add(d,"grow, wrap");
		 grammarPanel.add(e,"grow, wrap");
		 
		 this.add(stp, "grow, wrap");
		 this.add(grammarPanel,"grow, wrap");
	
	}
	private void setupPhrasePanel()
	{
		 SeparatedTitlePanel stp = new SeparatedTitlePanel("Phrases");
		
		 JLabel lblWord = new YellowLabel("to be or not to be");
		 JLabel d = new YellowLabel("fully loaded");
		 JLabel e = new YellowLabel("touchy feely");
	
				
		 phrasePanel.add(lblWord,"grow, wrap");
		 phrasePanel.add(d,"grow, wrap");
		 phrasePanel.add(e,"grow, wrap");
		 this.add(stp, "grow, wrap");
		 this.add(phrasePanel, "grow, wrap");
	}
	private void setupMistakePanel()
	{
		 SeparatedTitlePanel stp = new SeparatedTitlePanel("Mistakes");
			
	     JLabel lblWord = new YellowLabel("it's broke");
	     JLabel lblLine = new JLabel("----------");
		 JLabel e = new YellowLabel("it's broken");
		
					
		 mistakePanel.add(lblWord, "cell 1 0, growx, align right");
		 mistakePanel.add(lblLine, "cell 2 0, align center");
		 mistakePanel.add(e, "cell 3 0, growx, align left");
		
		 this.add(stp, "grow, wrap");
		 this.add(mistakePanel, "grow, wrap");	
	}
	private void setupHomeworkPanel()
	{
		SeparatedTitlePanel stp = new SeparatedTitlePanel("Homework");
		
		 JLabel lblWord = new YellowLabel("to be or not to be");
		 JLabel d = new YellowLabel("fully loaded");
		 JLabel e = new YellowLabel("touchy feely");
	
				
		 homeworkPanel.add(lblWord, "growx, wrap");
		 homeworkPanel.add(d, "growx, wrap");
		 homeworkPanel.add(e, "growx, wrap");
		 this.add(stp, "grow, wrap");
		 this.add(homeworkPanel, "grow, wrap");
	}
	private void setupLessonListPanel()
	{
		ArrayList<String> lesson = new ArrayList<String>();
		lesson.add("Lesson 1");
		lesson.add("Lesson 2");
		lesson.add("Lesson 3");
		lesson.add("Lesson 4");
		JList lessonList = new JList(lesson.toArray());
		
		lessonListPanel.add(lessonList, "span 4");
		lessonList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lessonList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		this.add(lessonListPanel, "grow,wrap");
	}
	
	// Panel getters
	
	public JPanel getAgendaPanel() { return agendaPanel; }
	public JPanel getWordPanel() { return wordPanel; }
	public JPanel getGrammarPanel() { return grammarPanel; }
	public JPanel getMistakePanel() { return mistakePanel; }
	public JPanel getPhrasePanel() { return phrasePanel; }
	public JPanel getHomeworkPanel() { return homeworkPanel; }
	
	class SeparatedTitlePanel extends JPanel
	{
		SeparatedTitlePanel(String title)
		{
		JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
		JLabel titleLabel = new JLabel(title);
		Component rigidArea = Box.createRigidArea(new Dimension(5, 5));
		this.setLayout(new MigLayout());
		this.add(rigidArea, "wrap");
		this.add(titleLabel, "split 2, pushx, span");
		this.add(separator, "growx, wrap");
		}
	}
}
