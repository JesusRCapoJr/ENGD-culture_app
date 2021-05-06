import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TaskButton extends Button{
	private Task task; 
	private String description; 

	public TaskButton(JPanel world, Task task, double upperLeftX, double upperLeftY, double width, double height) {
		super(task.getTitle(), upperLeftX, upperLeftY, width, height);
		this.world = world; 
		this.task = task; 
	}

	@Override 
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("TaskButton triggered"); 
				updateDescription(); 
				int l = task.getDescriptionSize(); 
				JLabel details = new JLabel(); 
				details.setText(task.getDescription());
				details.setLocation((int)upperLeftPosition.getX()-width, (int)upperLeftPosition.getY()-height*l/2);
				world.add(details); 
//				Button btn = new Button(task.getDescription(),upperLeftPosition.x-width, upperLeftPosition.y-height*l/2, width, height*l); 
				}
			}; 
			addActionListener(al); 
	}
	
	public void updateDescription(){
		this.description = this.task.getDescription();
	}
}