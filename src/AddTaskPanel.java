import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddTaskPanel {
	private JPanel gui; 
	private double panelSizeX; 
	private double panelSizeY; 
	
	public AddTaskPanel(double panelSizeX, double panelSizeY, JFrame world) {
		this.gui = new JPanel(); 
		world.add(gui); 
		this.panelSizeX = panelSizeX; 
		this.panelSizeY = panelSizeY; 
		
		//construct the whole window
	}
	
}
