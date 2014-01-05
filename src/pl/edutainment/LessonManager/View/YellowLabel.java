package pl.edutainment.LessonManager.View;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java.awt.Color;

public class YellowLabel extends JLabel {

	YellowLabel(String text)
	{
		super(text);
		setBackground(new Color(250,244,165));
		setOpaque(true);
		Border paddingBorder = BorderFactory.createEmptyBorder(3,10,3,10);
                /* Java 7
		 * Border border = BorderFactory.createLineBorder(Color.BLACK, 1, true);
		*/
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));	
	}
}
