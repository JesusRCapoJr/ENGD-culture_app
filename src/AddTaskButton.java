import java.awt.Color;
import java.awt.Insets;
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
	private static final Color BGC = new Color(0,0,0); 
	BufferedImage icon; 
	
	public AddTaskButton(JFrame world, double upperLeftX, double upperLeftY, double width, double height) {
		super(world, upperLeftX, upperLeftY, width, height); 
		this.world = world; 
		try {
			this.icon = ImageIO.read(new File("texture/test4.png")); 
		}catch(Exception e) {
			this.icon = null; 
		}
		System.out.print(this.icon == null);
		if(this.icon != null) {
			this.setIcon(new ImageIcon(icon));
			//this.setBorder(null);
		}
	}
	
	public void handleClick() {
		new AddTaskPanel(world.getSize().getWidth() * ADD_TASK_PANEL_X_RATIO, world.getSize().getWidth() * ADD_TASK_PANEL_Y_RATIO, world); 
	}
}
