package pl.edutainment.LessonManager;

import org.joda.time.*;
import pl.edutainment.LessonManager.Entry.*;

public abstract class Lesson 
{

	private int lessonID;
		
	private LocalDate lessonDate;
	private LocalTime lessonStartTime;
	private LocalTime lessonStopTime;
	
	private Student student;
	private Group group;
	
	private AgendaEntry agendaEntry = new AgendaEntry();
	private WordEntry wordEntry = new WordEntry();
	private GrammarEntry grammarEntry = new GrammarEntry();
	private PhraseEntry phraseEntry = new PhraseEntry();
	private MistakeCorrectionEntry mcEntry = new MistakeCorrectionEntry();
	private HomeworkEntry homeworkEntry = new HomeworkEntry();
	
	// Getters
	
	public int getLessonID() { return lessonID; }
	public LocalDate getLessonDate() { return lessonDate; }
	public LocalTime getStartTime()  { return lessonStartTime; }
	public LocalTime getEndTime() { return lessonStopTime; }
	public Student getStudent() { return student; }
	public Group getGroup() { return group; }
	
	public AgendaEntry getAgendaEntry() { return agendaEntry; }
	public WordEntry getWordEntry() { return wordEntry; }
	public GrammarEntry getGrammarEntry() { return grammarEntry; }
	public PhraseEntry getPhraseEntry() { return phraseEntry; }
	public MistakeCorrectionEntry getMistakeCorrectionEntry() { return mcEntry; }
	public HomeworkEntry getHomeworkEntry() { return homeworkEntry; }
	
	// Setters
	
	public void setLessonDate(LocalDate lessonDate) { this.lessonDate = lessonDate; }
	public void setLessonStartTime(LocalTime lessonStartTime) { this.lessonStartTime = lessonStartTime; }
	public void setLessonStopTime(LocalTime lessonStopTime) { this.lessonStopTime = lessonStopTime; }
	public void setStudent(Student student) { this.student = student; }
	public void setGroup(Group group) {this.group = group; }
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Lesson #");
		sb.append(lessonID);
		sb.append(" | Date: " + this.getLessonDate().toString());
		sb.append(" | Start: " + this.getStartTime().toString("HH:mm"));
		sb.append(" | Stop: " + this.getEndTime().toString("HH:mm"));
		sb.append("\n" + agendaEntry.toString());
		sb.append("\n" + wordEntry.toString());
		sb.append("\n" + grammarEntry.toString());
		sb.append("\n" + phraseEntry.toString());
		sb.append("\n" + mcEntry.toString());
		sb.append("\n" + homeworkEntry.toString());
		
		return sb.toString();
		
	}
}
