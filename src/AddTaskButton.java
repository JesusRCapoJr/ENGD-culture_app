import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class AddTaskButton extends Button{
	
	private JFrame world;  
	public static final double ADD_TASK_PANEL_X_RATIO = 0.3;
	public static final double ADD_TASK_PANEL_Y_RATIO = 0.5;  
	BufferedImage icon; 
	
	public AddTaskButton(JFrame world, double upperLeftX, double upperLeftY, double width, double height) {
		super("", new Point((int)upperLeftX, (int)upperLeftY)); //waiting for changes in Button
		this.world = world; 
		this.setSize((int)width, (int)height);
		try {
			this.icon = ImageIO.read(new File("texture/test.jpg")); 
		}catch(Exception e) {
			this.icon = null; 
		}
		if(this.icon != null) {
			this.setIcon(new ImageIcon(icon));
		}
	}
	
	public void handleClick() {
		new AddTaskPanel(world.getSize().getWidth() * ADD_TASK_PANEL_X_RATIO, world.getSize().getWidth() * ADD_TASK_PANEL_Y_RATIO, world); 
	}
}
