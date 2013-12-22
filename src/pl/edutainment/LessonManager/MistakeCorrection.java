package pl.edutainment.LessonManager;

public class MistakeCorrection {

	private String mistake;
	private String correction;
	
	MistakeCorrection(String mistake, String correction)
	{
		this.mistake = mistake;
		this.correction = correction;
	}
	
	public String getMistake() { return mistake; }
	public String getCorrection() { return correction; }
	
	public void setMistake(String mistake) { this.mistake = mistake; }
	public void setCorrection(String correction ) { this.correction = correction; }

}
