import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaskPanel extends JPanel {
	Task pairedTask;
	
	/**
	 * Create the panel.
	 */
	public TaskPanel(Task pairedTask) {
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("TaskPanel got clicked.");
			}
		});
		
		this.pairedTask = pairedTask;
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setHgap(5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Completed");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		add(chckbxNewCheckBox);
		
		JLabel TaskTitle = new JLabel(pairedTask.getTitle());
		add(TaskTitle);
		
		JLabel DueDate = new JLabel(pairedTask.getDueDate());
		add(DueDate);

	}

}
