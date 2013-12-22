package pl.edutainment.LessonManager.Entry;
import pl.edutainment.LessonManager.*;
import java.util.ArrayList;
import java.util.List;

public class MistakeCorrectionEntry {

	private List<MistakeCorrection> mcList = new ArrayList<MistakeCorrection>();
	
	public void add(MistakeCorrection mc)
	{
		mcList.add(mc);
	}
	public void remove(MistakeCorrection mc)
	{
		mcList.remove(mc);
	}
	public List<MistakeCorrection> getList() { return mcList; }
	
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Mistake\t\t\tCorrection\n");
		
		for(MistakeCorrection m : mcList)
		{
			sb.append(m.getMistake());
			sb.append("\t-\t");
			sb.append(m.getCorrection());
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
