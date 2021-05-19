//Author: Jesus Capo
//Additional Contributors: Steven Xia

import java.awt.Color;
import java.io.Serializable;

public class Label implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 841123753420201744L;
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
