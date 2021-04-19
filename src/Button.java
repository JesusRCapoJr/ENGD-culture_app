import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

	public Button(JPanel panel, String text, Point upperLeftPosition) {
		super(text);
		this.setText(text);
		this.setPanel(panel);
		this.createAction();
		this.setPosition(upperLeftPosition);
	}

	public void setPanel(JPanel inputPanel) { // Panel
		this.panel = inputPanel;
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public void setText(String text) { // Text
		this.text = text;

	}

	public String getText() {
		return this.text;
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


	public void createAction() {          // Action
		ActionListener al = new ActionListener() {
			public boolean actionPerformed(ActionEvent e) {
				return true;
				}
			}
	}
//	public void setAction() {
//
//	}
//	
//	public void getAction() {    
//
//	}

	// getters
	// public ??? getAppearance(){}

}
