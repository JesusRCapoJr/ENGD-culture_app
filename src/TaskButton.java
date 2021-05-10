import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TaskButton extends ToggleButton{
	private Task task; 
	private String description; 
	private JPanel btnPanel = new JPanel(); 
	private JLabel details; 
	private boolean selected; 
	private final int FONT_SIZE = 12; 

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
				//System.out.println("TaskButton triggered: "); 
				selected = !selected; 
				if(selected) {
					HomeOverviewPanel.cleanAll();
					displayTask(); 
					setSelected(true); 
				}else {
					unClick(); 
				}
			}
		}; 
		addActionListener(al); 
	}
	
	public void updateDescription(){
		this.description = this.task.getDescription();
	}
	
	public void displayTask() {
		updateDescription(); 
		
		int l = 20; 
		String choppedDescription = ""; 
		
		btnPanel.setBackground(Color.GRAY);
		btnPanel.setBounds((int)upperLeftPosition.getX()-width, (int)upperLeftPosition.getY()-(l-height)/2, width, l);
		System.out.println("btnPanel Bounds: "+((int)upperLeftPosition.getX()-width)+", "+((int)upperLeftPosition.getY()-(l-height)/2)+", "+width+", "+l); 
		world.add(btnPanel); 
		btnPanel.setVisible(true);
		
		//System.out.println(this.description); 
		details.setBounds(0,0,width,l);
		//details.setSize(width, l); //This method is useless
		details.setText("Description: "+this.task.getDescriptionByRows(width, "Description: ".length()*FONT_SIZE, FONT_SIZE));
		//details.setHorizontalAlignment(SwingConstants.LEADING); 
		//details.setVerticalAlignment(SwingConstants.CENTER); 
		details.setVisible(true);
		
		btnPanel.add(details); 
		
	}
	
	public void unClick() {
		btnPanel.setVisible(false);
		selected = false; 
		this.setSelected(false);
	}
}