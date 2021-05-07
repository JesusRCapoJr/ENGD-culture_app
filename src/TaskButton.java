import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TaskButton extends ToggleButton{
	private Task task; 
	private String description; 
	private JLabel details; 

	public TaskButton(JPanel world, Task task, double upperLeftX, double upperLeftY, double width, double height) {
		super(task.getTitle(), upperLeftX, upperLeftY, width, height);
		this.world = world; 
		this.task = task; 
		this.details = new JLabel(); 
		world.add(details); 
	}

	@Override 
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("TaskButton triggered: "); 
				if(toggle) {
					HomeOverviewPanel.cleanAll(); 
					details.setVisible(false);
					//world.repaint();
				}else {
					displayTask(); 
					//world.repaint();
				}
				toggle = !toggle; 
			}
		}; 
		addActionListener(al); 
	}
	
	public void displayTask() {
		updateDescription(); 
		
		//int l = task.getDescriptionSize(); 
		int l = 100; 
		
		details.setText(task.getDescription());
		details.setBounds((int)upperLeftPosition.getX()-width, (int)upperLeftPosition.getY()-height*l/2, width, l);
		//details.setSize(width, l);
		details.setVisible(true);
	}
	
	public void updateDescription(){
		this.description = this.task.getDescription();
	}
}