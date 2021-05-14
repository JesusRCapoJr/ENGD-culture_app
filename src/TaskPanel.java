import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaskPanel extends JPanel {
	Task pairedTask;
	
	/**
	 * Create the panel.
	 */
	public TaskPanel(Task pairedTask, int upperLeftX, int upperLeftY, int width, int height) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.pairedTask = pairedTask;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("TaskPanel got clicked.");
			}
		});

		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setHgap(1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Completed");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		add(chckbxNewCheckBox);
		
		JLabel TaskTitle = new JLabel(pairedTask.getTitle());
		add(TaskTitle);
		
		JLabel DueDate = new JLabel(pairedTask.getDescription());
		add(DueDate);
		
		
		System.out.println(pairedTask.getTitle() + " got created");
	}

}
