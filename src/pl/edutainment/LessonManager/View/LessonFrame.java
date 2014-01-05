package pl.edutainment.LessonManager.View;

import java.awt.*;
import java.awt.event.*;

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

	private JPanel mainPanel = new JPanel();
	private LessonPanel lessonPanel = new LessonPanel();
	private JPanel buttonPanel = new JPanel();
	private JButton saveButton = new JButton("Save");
	private JButton closeButton = new JButton("Close");
	
	public LessonFrame()
	{
		mainPanel.setLayout(new MigLayout());
		JScrollPane scrollPane = new JScrollPane(lessonPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		mainPanel.add(scrollPane, "wrap");
	
	
		
		setupButtonPanel();
		mainPanel.add(buttonPanel);
		
		this.getContentPane().add(mainPanel);
	
		this.pack();
		this.setLocationRelativeTo(null);
	
		this.setVisible(true);
		
	}
	private void setupButtonPanel()
	{
		buttonPanel.setLayout(new MigLayout("fillx"));
		buttonPanel.add(saveButton, "align right");
		buttonPanel.add(closeButton, "align right");
		
	}
	private void getHorizontalSectionTitle(String title)
	{
	}
	public void addSaveButtonListener(ActionListener al)
	{
		saveButton.addActionListener(al);
	}
	public void addCloseButtonListener(ActionListener al)
	{
		closeButton.addActionListener(al);
	}
	public JPanel getMainPanel()
	{ 
		return lessonPanel; 
	}
	public void addAgenda(String agenda)
	{
		
		YellowLabel tmpLabel = new YellowLabel(agenda);
		
		lessonPanel.getAgendaPanel().add(tmpLabel, "growx, wrap");
		this.repaint();
		this.revalidate();
	}
	public void addWord(String word)
	{
		YellowLabel tmpLabel = new YellowLabel(word);
		
		lessonPanel.getWordPanel().add(tmpLabel, "growx");
		this.repaint();
		this.revalidate();
	}

	public void addGrammar(String grammar)
	{
		YellowLabel tmpLabel = new YellowLabel(grammar);
		lessonPanel.getGrammarPanel() .add(tmpLabel, "growx, wrap");
		this.repaint();
		this.revalidate();
		
	}
	public void addHomework(String homework)
	{
		YellowLabel tmpLabel = new YellowLabel(homework);
		lessonPanel.getHomeworkPanel().add(tmpLabel,"growx,wrap");
		this.repaint();
		this.revalidate();
	}
	public void addPhrase(String phrase)
	{
		YellowLabel tmpLabel = new YellowLabel(phrase);
		lessonPanel.getPhrasePanel().add(tmpLabel, "growx, wrap");
		this.repaint();
		this.revalidate();
		
	}
	public void addMistake(String mistake, String correction)
	{
		YellowLabel tmpLabel1 = new YellowLabel(mistake);
		YellowLabel tmpLabel2 = new YellowLabel(correction);
		lessonPanel.getMistakePanel().add(tmpLabel1, "growx, wrap");
		this.repaint();
		this.revalidate();
		
	}
	
}
