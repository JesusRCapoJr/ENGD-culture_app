

import java.awt.Color;

public class Label {
	//TODO: implement shape. 
	private String text; 
	private boolean isSelected;
	//private ??? shape; 
	
	public Label(String text) {
		this.text = text; 
		this.isSelected = true; 
	}
	
	//setters 
	public void setText(String newText) {
		this.text = newText; 
	}
	
	
	public String getText() {
		return this.text; 
	}
	
	public void changeState() {
		this.isSelected = !this.isSelected; 
	}
	
	public void setVisible() {
		this.isSelected = true; 
	}
}
