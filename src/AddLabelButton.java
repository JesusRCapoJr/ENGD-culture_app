import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class AddLabelButton extends Button {
	private JPanel world;
	public static final double ADD_TASK_PANEL_X_RATIO = 0.3;
	public static final double ADD_TASK_PANEL_Y_RATIO = 0.5;
	private Color BGC = new Color(255, 0, 0, 0);

	public AddLabelButton(JPanel world, double upperX, double upperY, double width, double height) {
		this.world = world;
	}

	public void createAction() { // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			addLabel();
			}
		};
		addActionListener(al);
	}

	/*
	 * When the method is called, it creates a new label. It is dependent on the
	 * action listener for the addLabelButton
	 * 
	 * How should we access the panel/
	 */
	public void addLabel() {
		final String labelName = JOptionPane.showInputDialog("Name of Label: ");
		Label newLabel = new Label(labelName);
		//world.addLabel(newLabel) ??? what do I acces to add the label button
		
	}

}