//Author: John Chung 

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class CheckButton extends JToggleButton{

	// TODO: implement appearance, link
		public JPanel world;
		protected Task task;
		protected String text;
		protected Point upperLeftPosition;
		protected int width; 
		protected int height; 
		protected Color color;
		private boolean toggle; 
		final private CheckButton thisCheckButton;
		// protected ??? link

		// Getters, setters and variables for size and text are implemented by JButton.
		// Size is in Dimension, and text is in String

		// setters
		public CheckButton(String text) { //?
			super(); 
			this.setText(text);
			this.createAction();
			color = new Color(255,255,255);
			this.thisCheckButton=this;
		}
		
		public CheckButton(String text, Task task, double upperLeftX, double upperLeftY, double width, double height) {
			super(); 
			this.task = (task);
			this.setText(text);
			this.createAction();
			this.width = (int)width; 
			this.height = (int)height; 
			this.upperLeftPosition = new Point((int)upperLeftX, (int)upperLeftY); 
			this.setBounds((int)upperLeftX, (int)upperLeftY, this.width, this.height);
			color = new Color(255,255,255);
			this.setLayout(null);
			this.toggle = false; 
			this.thisCheckButton=this;
			//System.out.println("Check button created");
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
		private void changeState() throws Exception { 
			if (this.toggle == false) {
				this.toggle = true;
				this.task.setCompleted(true);
				System.out.println("changed to true");
			}
			else {
				this.toggle = false;
				this.task.setCompleted(false);
				System.out.println("changed to false");
			}
		}

		public void createAction() {                  // Action
			ActionListener al = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//System.out.println("Put actions to be preformed on click here");
					try {
						thisCheckButton.changeState();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				};
				addActionListener(al); 
		}

}
