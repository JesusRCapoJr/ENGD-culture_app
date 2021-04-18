import java.awt.Point;
import java.awt.geom.Point2D;

import javax.swing.JButton;

public abstract class Button extends JButton{
	//TODO: implement appearance, link
	protected String text; 
	protected Point upperLeftPosition;
	//protected ??? appearance
	//protected ??? link 
	
	//Getters, setters and variables for size and text are implemented by JButton. Size is in Dimension, and text is in String
	
	//setters 
	public void setAppearance(/*appearance*/) {
		
	}
	
	public void setPosition(Point pt) {
		this.upperLeftPosition = pt; 
	}
	
	public void setPosition(double x, double y) {
		this.upperLeftPosition = new Point((int)x,(int)y); 
	}
	
	//getters 
	//public ??? getAppearance(){}
	
	public Point getPosition() {
		return this.upperLeftPosition; 
	}
	
}
