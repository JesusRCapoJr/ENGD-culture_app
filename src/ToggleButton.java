import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ToggleButton extends JToggleButton{

	// TODO: implement appearance, link
		public JPanel world;
		protected String text;
		protected Point upperLeftPosition;
		protected int width; 
		protected int height; 
		protected Color color;
		protected boolean toggle; 
		// protected ??? link

		// Getters, setters and variables for size and text are implemented by JButton.
		// Size is in Dimension, and text is in String

		// setters
		public ToggleButton(String text) { //?
			super(); 
			this.setText(text);
			this.createAction();
			color = new Color(255,255,255);
		}
		
		public ToggleButton(String text, double upperLeftX, double upperLeftY, double width, double height) {
			super(); 
			this.setText(text);
			this.createAction();
			this.width = (int)width; 
			this.height = (int)height; 
			this.upperLeftPosition = new Point((int)upperLeftX, (int)upperLeftY); 
			this.setBounds((int)upperLeftX, (int)upperLeftY, this.width, this.height);
			color = new Color(255,255,255);
			this.setLayout(null);
			this.toggle = false; 
		}

		public void setPosition(double x, double y) { // Position
			this.upperLeftPosition = new Point((int) x, (int) y);
		}

		public void setPosition(Point pt) {
			this.upperLeftPosition = pt;
		}

		public Point getPosition() {
			return this.upperLeftPosition;
		}

		public void setAppearance(/* appearance */) { // Appearance

		}
		public void changeColorState() { 
			if (this.color == new Color(255,255,255)) {
				this.color = new Color(0,0,0);
			}
			else {
				this.color = new Color(255,255,255);
			}
		}

		public void createAction() {                  // Action
			ActionListener al = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Put actions to be preformed on click here");		// what it does goes here
					}
				};
				addActionListener(al); 
		}

}
