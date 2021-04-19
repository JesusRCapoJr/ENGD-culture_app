import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddTaskPanel {
	private JPanel gui; 
	private double windowSizeX; 
	private double windowSizeY; 
	
	public AddTaskPanel(double windowSizeX, double windowSizeY, JFrame world) {
		this.gui = new JPanel(); 
		world.add(gui); 
		this.windowSizeX = windowSizeX; 
		this.windowSizeY = windowSizeY; 
		
		//construct the whole window
	}
	
}
