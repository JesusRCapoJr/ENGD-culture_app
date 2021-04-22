

import java.awt.Color;

public class Label {
	//TODO: implement shape. 
	private String text; 
	private Color color; 
	//private ??? shape; 
	
	public Label(String text, Color color/*, ??? shape*/) {
		this.text = text; 
		this.color = color; 
		//this.shape = shape; 
	}
	
	//setters 
	public void setText(String newText) {
		this.text = newText; 
	}
	
	public void setColor(Color newColor) {
		this.color = newColor; 
	}
	
	/*public void setShape(??? newShape) {
		this.shape = newShape; 
	}*/ 
	
	public String getText() {
		return this.text; 
	}
}
