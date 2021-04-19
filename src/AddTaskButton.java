import java.awt.Point;

import javax.swing.JFrame;

public class AddTaskButton extends Button{
	
	private JFrame world; 
	private double width; 
	private double height; 
	public static final double ADD_TASK_PANEL_X_RATIO = 0.3;
	public static final double ADD_TASK_PANEL_Y_RATIO = 0.5;  
	
	public AddTaskButton(JFrame world, double upperLeftX, double upperLeftY, double width, double height) {
		super("", new Point((int)upperLeftX, (int)upperLeftY)); //waiting for changes in Button
		this.world = world; 
		this.width = width; 
		this.height = height; 
	}
	
	public void handleClick() {
		new AddTaskPanel(world.getSize().getWidth() * ADD_TASK_PANEL_X_RATIO, world.getSize().getWidth() * ADD_TASK_PANEL_Y_RATIO, world); 
	}
}
