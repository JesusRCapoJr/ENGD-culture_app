import java.awt.Color;

import javax.swing.JPanel;

public class FolderTaskPanel extends JPanel{
	
	private int width;
	private int height; 
	private Task myTask; 
	
	public FolderTaskPanel(int upperLeftX, int upperLeftY, int width, int height, Task task) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		this.myTask = task; 
		this.setBackground(Color.LIGHT_GRAY); 
		
		constructAll(); 
	}
	
	public void constructAll() {
		this.add(new TaskButton(this, this.myTask, 0, 0, width, height)); 
		System.out.println("Task constructed"); 
		this.repaint();
	}
}
