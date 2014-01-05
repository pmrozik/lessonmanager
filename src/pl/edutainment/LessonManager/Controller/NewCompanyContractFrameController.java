package pl.edutainment.LessonManager.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.edutainment.LessonManager.Controller.NewStudentFrameController.SaveButtonListener;
import pl.edutainment.LessonManager.View.*;
import pl.edutainment.LessonManager.CompanyContract;

public class NewCompanyContractFrameController {

	private NewCompanyContractFrame nccf;
	private CompanyContract companyContract;
	
	public NewCompanyContractFrameController()
	{
		nccf = new NewCompanyContractFrame();
		nccf.addSaveButtonListener(new SaveButtonListener());
	}
	public class SaveButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			// Check whether fields have been filled in correctly
			if (nccf.isFormValid())
			{
			
			
			}
		}
	}
	
}
