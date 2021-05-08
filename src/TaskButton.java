import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TaskButton extends ToggleButton{
	private Task task; 
	private String description; 
	private JPanel btnPanel = new JPanel(); 
	private JLabel details; 
	private boolean selected; 

	public TaskButton(JPanel world, Task task, double upperLeftX, double upperLeftY, double width, double height) {
		super(task.getTitle(), upperLeftX, upperLeftY, width, height);
		this.world = world; 
		this.task = task; 
		this.details = new JLabel(); 
		world.add(details); 
		selected = false; 
	}

	@Override 
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("TaskButton triggered: "); 
				selected = !selected; 
				if(selected) {
					displayTask(); 
					//world.repaint();
				}else {
					btnPanel.setVisible(false);
					HomeOverviewPanel.cleanAll(); 
					//world.repaint();
				}
			}
		}; 
		addActionListener(al); 
	}
	
	public void displayTask() {
		updateDescription(); 
		
		//int l = task.getDescriptionSize(); 
		int l = 100; 
		
		btnPanel.setBackground(Color.GRAY);
		btnPanel.setBounds(100, 100, 200, 300);
		world.add(btnPanel); 
		btnPanel.setVisible(true);
		//world.setVisible(false);
		
		//details.setText(task.getDescription());
		details.setText("aiwhfoifheiufhjalzhsie");
		//details.setBounds((int)upperLeftPosition.getX()-width, (int)upperLeftPosition.getY()-(l-height)/2, width, l);
		details.setBounds(0,0,width,l);
		details.setSize(width, l);
		details.setVisible(true);
		btnPanel.add(details); 
		
	}
	
	public void updateDescription(){
		this.description = this.task.getDescription();
	}
}