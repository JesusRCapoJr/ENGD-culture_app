import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class Button extends JButton {
	// TODO: implement appearance, link
	public JPanel panel;
	protected String text;
	protected Point upperLeftPosition;
	// protected ??? appearance
	// protected ??? link

	// Getters, setters and variables for size and text are implemented by JButton.
	// Size is in Dimension, and text is in String

	// setters
	public Button() {
		this.createAction();
	}
	
	public Button(String text) {
		this.setText(text);
		this.createAction();
	}
	
	public Button(String text, Point upperLeftPosition) {
		this.setText(text);
		this.createAction();
		this.setPosition(upperLeftPosition);
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

	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Put actions to be preformed on click here");		// what it does goes here
				}
			};
	}
}

	// getters
	// public ??? getAppearance(){}

}