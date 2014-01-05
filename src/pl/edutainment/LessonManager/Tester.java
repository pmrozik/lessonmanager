package pl.edutainment.LessonManager;

import pl.edutainment.LessonManager.Entry.*;
import pl.edutainment.LessonManager.Controller.*;
import pl.edutainment.LessonManager.View.*;

import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

import javax.swing.*;

import org.joda.time.*;

public class Tester {

	
	public static void main(String[] args)
	{
		
		/*
		Student s = new Student.Builder(1, "John", "Wayne").primaryEmail("john.wayne@me.com").primaryPhone("555-1212").build();
		
		System.out.println(s.getCountry());
		
		System.out.println(GroupList.INSTANCE.getList().toString());
		*/
		// createCompanyContract();
		// createStudent();
	
		// createStudentsAndGroup();
		// createCompanyContract();
		//ContractList.INSTANCE.printContracts();
		
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

		
		DerbyDB.INSTANCE.values();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	JTree mainTree = new CustomJTree(JTreeModel.INSTANCE.getModel());
        		LessonManager lm = new LessonManager();
        		JTreeController jtc = new JTreeController(mainTree, lm);
            }
        });
		
		/*JTree mainTree = new CustomJTree(JTreeModel.INSTANCE.getModel());
		LessonManager lm = new LessonManager();
		JTreeController jtc = new JTreeController(mainTree, lm);*/
			
		/*
		for(Student student: StudentList.INSTANCE.getList())
		{
			System.out.println(student);
		}
		
		DerbyDB.INSTANCE.closeConnection();
		*/
	}
	public static void createStudentsAndGroup()
	{
		Address address = new Address("Szumiacych Traw 2b/17", "Warszawa", "03-289", "Mazowieckie", "Poland");
		Student pablo = new Student.Builder(1, "Pawel", "Mrozik").primaryEmail("pmrozik@gmail.com").address(address).build();
		Student aga = new Student.Builder(2, "Agnieszka" ,  "Piekarska").primaryEmail("aga.wicher@gmail.com").address(address).build();
		Student natalia = new Student.Builder(3, "Natalia", "Kaczmarczyk").primaryEmail("natkakaczka@gmail.com").address(address).build();
		
		Group home = new Group(3, "Home Group");
		
		home.addStudentToGroup(pablo);
		home.addStudentToGroup(aga);
		home.addStudentToGroup(natalia);
		
		GroupList.INSTANCE.addGroup(home);
		//GroupList.INSTANCE.printGroups();
		
		Contract contract = new IndividualContract(pablo);
		contract.setGroup(home);
		contract.setNumberOfLessons(30);
		contract.setStartDate(LocalDate.now().plusDays(7));
		contract.setStopDate(LocalDate.now().plusDays(90));
		contract.setLessonDuration(Minutes.minutes(60));
		contract.setTotalPrice(new Price(contract.getNumberOfLessons()*75, Currency.getInstance("USD")));
		
		ContractList.INSTANCE.addContract(contract);
		
		Lesson cLesson = new ContractLesson(contract);
		
		cLesson.setLessonDate(LocalDate.now());
		cLesson.setLessonStartTime(LocalTime.now());
		cLesson.setLessonStopTime(LocalTime.now().plusMinutes(contract.getLessonDuration().getMinutes()));
		
		AgendaEntry agendaEntry = cLesson.getAgendaEntry();
		WordEntry wordEntry = cLesson.getWordEntry();
		GrammarEntry grammarEntry = cLesson.getGrammarEntry();
		PhraseEntry phraseEntry = cLesson.getPhraseEntry();
		MistakeCorrectionEntry mcEntry = cLesson.getMistakeCorrectionEntry();
		HomeworkEntry homeworkEntry = cLesson.getHomeworkEntry();
		
		agendaEntry.add("Natural English p. 153");
		wordEntry.add("anonymous");
		wordEntry.add("incredible");
		wordEntry.add("populate");
		wordEntry.add("defiant");
		grammarEntry.add("present perfect");
		phraseEntry.add("to be or not to be");
		mcEntry.add(new MistakeCorrection("Yesterday I tell", "Yesterday I told"));
		homeworkEntry.add("No homework");
		
		System.out.println(cLesson);

	}
	public static void createStudent()
	{
		Address address = new Address("Szumiacych Traw 2b/17", "Warszawa", "03-289", "Mazowieckie", "Poland");
		Student pabloStudent = new Student.Builder(1, "Pawel", "Mrozik").primaryEmail("pmrozik@gmail.com").address(address).build();
		
		Group iTeam = new Group(1, "Inter Team 1");
		pabloStudent.setGroup(iTeam);
		
		Contract c = new IndividualContract(pabloStudent);
		c.setLessonDuration(Minutes.minutes(60));
		c.setStartDate(new LocalDate(2013, 7, 1));
		c.setStopDate(new LocalDate(2013, 9, 1));
		c.setNumberOfLessons(1.5*12);
	
		c.setTotalPrice(new Price(c.getNumberOfLessons()*60, Currency.getInstance("USD")));
		c.setAmountPaid(new Price(0, Currency.getInstance("USD")));
		
		ContractLesson cLesson = new ContractLesson(c);
		
		cLesson.setLessonDate(LocalDate.now());
		cLesson.setLessonStartTime(LocalTime.now());
		cLesson.setLessonStopTime(LocalTime.now().plusMinutes(c.getLessonDuration().getMinutes()));
		
		AgendaEntry agendaEntry = cLesson.getAgendaEntry();
		WordEntry wordEntry = cLesson.getWordEntry();
		GrammarEntry grammarEntry = cLesson.getGrammarEntry();
		PhraseEntry phraseEntry = cLesson.getPhraseEntry();
		MistakeCorrectionEntry mcEntry = cLesson.getMistakeCorrectionEntry();
		HomeworkEntry homeworkEntry = cLesson.getHomeworkEntry();
		
		agendaEntry.add("Natural English p. 153");
		wordEntry.add("anonymous");
		wordEntry.add("incredible");
		wordEntry.add("populate");
		wordEntry.add("defiant");
		grammarEntry.add("present perfect");
		phraseEntry.add("to be or not to be");
		mcEntry.add(new MistakeCorrection("Yesterday I tell", "Yesterday I told"));
		homeworkEntry.add("No homework");
		
		System.out.println(cLesson);
		System.out.println(cLesson.getContract().toString());
		
	}
	public static void createCompanyContract()
	{
		Address address = new Address("Bialolecka 127","Warszawa",  "03-289", "Mazowieckie", "Poland");
			
		Company interTeam = new Company(1, "Inter Team", address);
		
		interTeam.setCompanyName("Inter-Team Polska Sp. z o.o.");
		
		Contract c = new CompanyContract(interTeam);
		
		LocalDate startDate = new LocalDate(2013, 06, 21);
		LocalDate stopDate = new LocalDate(2013, 07, 30);
		
		Currency pln = Currency.getInstance("USD");
		c.setStartDate(startDate);
		c.setStopDate(stopDate);
		c.setTotalPrice(new Price(3000, pln));
		c.setAmountPaid(new Price(0, pln));
		c.setLessonDuration(Minutes.minutes(60));
		c.setNumberOfLessons(50);
		
		ContractList.INSTANCE.addContract(c);
		
	}
	
}
