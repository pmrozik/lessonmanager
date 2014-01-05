package pl.edutainment.LessonManager.Controller;
import pl.edutainment.LessonManager.*;
import pl.edutainment.LessonManager.View.*;

import java.awt.event.*;
import javax.swing.*;

public class LessonFrameController {

	Lesson lesson;
	LessonFrame lessonFrame;
	
	
	public LessonFrameController()
	{
		lessonFrame = new LessonFrame();
		setKeyBindings();
	}
	LessonFrameController(Lesson lesson)
	{
		
	}
	private void setKeyBindings()
	{
		// Agenda action
		lessonFrame.getMainPanel().getInputMap().put(KeyStroke.getKeyStroke("typed a"),
		"agendaAction");
		lessonFrame.getMainPanel().getActionMap().put("agendaAction", new AgendaAction());
		
		// Word action
		lessonFrame.getMainPanel().getInputMap().put(KeyStroke.getKeyStroke("typed w"),
                "wordAction");
		lessonFrame.getMainPanel().getActionMap().put("wordAction", new WordAction());
	

		// Grammar action 
		lessonFrame.getMainPanel().getInputMap().put(KeyStroke.getKeyStroke("typed g"),
                "grammarAction");
		lessonFrame.getMainPanel().getActionMap().put("grammarAction", new GrammarAction());
	
		// Phrase action 
		lessonFrame.getMainPanel().getInputMap().put(KeyStroke.getKeyStroke("typed p"),
		                "phraseAction");
		lessonFrame.getMainPanel().getActionMap().put("phraseAction", new PhraseAction());
				
		// Homework action
		lessonFrame.getMainPanel().getInputMap().put(KeyStroke.getKeyStroke("typed h"),
				"homeworkAction");
		lessonFrame.getMainPanel().getActionMap().put("homeworkAction", new HomeworkAction());


	}
	class AgendaAction extends AbstractAction {
	    public void actionPerformed(ActionEvent e) {
	        displayResult("Pressed A", e);
	        String agenda = JOptionPane.showInputDialog(lessonFrame, "Enter agenda item");
	        if(agenda != null && agenda.length() > 0)
	        {
	        	lessonFrame.addAgenda(agenda);
	        }
	    }
	    private void displayResult(String s, ActionEvent e)
	    {
	    	System.out.println(s);
	    }    
	}
	class WordAction extends AbstractAction {
	    public void actionPerformed(ActionEvent e) {
	        displayResult("Pressed W", e);
	        String word = JOptionPane.showInputDialog(lessonFrame, "Enter word");
	        if(word != null && word.length() > 0)
		{
	        	lessonFrame.addWord(word);
	        }
	    }
	    private void displayResult(String s, ActionEvent e)
	    {
	    	System.out.println(s);
	    }
	    
	}
	class GrammarAction extends AbstractAction {
	    public void actionPerformed(ActionEvent e) {
	    	displayResult("Pressed G", e);
	        String grammar = JOptionPane.showInputDialog(lessonFrame, "Enter grammar item");
	        if(grammar != null && grammar.length() > 0)
	        {
	        	lessonFrame.addGrammar(grammar);
	        }
	    }
	    private void displayResult(String s, ActionEvent e)
	    {
	    	System.out.println(s);
	    }
	    
	}
	class PhraseAction extends AbstractAction {
	    public void actionPerformed(ActionEvent e) {
	        displayResult("Pressed P", e);
	        String phrase = JOptionPane.showInputDialog(lessonFrame, "Enter phrase item");
	        if(phrase != null && phrase.length() > 0)
	        {
	        	lessonFrame.addPhrase(phrase);
	        }
	    }
	    private void displayResult(String s, ActionEvent e)
	    {
	    	System.out.println(s);
	    }
	    
	}
	class HomeworkAction extends AbstractAction {
	    public void actionPerformed(ActionEvent e) {
	        displayResult("Pressed H", e);
	    
	    	String homework = JOptionPane.showInputDialog(lessonFrame, "Enter homework item");
		if(homework != null && homework.length() > 0)
		{
			lessonFrame.addHomework(homework);
	 	}
	    }
	    private void displayResult(String s, ActionEvent e)
	    {
	    	System.out.println(s);
	    }
	    
	}
}

