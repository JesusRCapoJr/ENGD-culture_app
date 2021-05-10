import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TaskButton extends ToggleButton{
	private Task task; 
	private String description; 
	private JPanel btnPanel = new JPanel(); 
	private JTextArea details; 
	private boolean selected; 
	private final int FONT_SIZE = 8; 

	public TaskButton(JPanel world, Task task, double upperLeftX, double upperLeftY, double width, double height) {
		super(task.getTitle(), upperLeftX, upperLeftY, width, height); 
		this.world = world; 
		this.task = task; 
		this.details = new JTextArea(); 
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
		
		int l = 20*this.task.getDescriptionRows(width, "Description: ".length()*FONT_SIZE, FONT_SIZE); 
		String choppedDescription = this.task.getDescriptionByRows(width, "Description: ".length()*FONT_SIZE, FONT_SIZE); 
		
		btnPanel.setBackground(Color.GRAY);
		btnPanel.setLayout(null);
		btnPanel.setBounds((int)upperLeftPosition.getX()-width, (int)upperLeftPosition.getY()-(l-height)/2, width, l);
		System.out.println("btnPanel Bounds: "+((int)upperLeftPosition.getX()-width)+", "+((int)upperLeftPosition.getY()-(l-height)/2)+", "+width+", "+l); 
		world.add(btnPanel); 
		btnPanel.setVisible(true);
		
		details.setBounds(10,0,width,l);
		details.setText("Description: "+choppedDescription);
		details.setBackground(Color.GRAY);
		details.setVisible(true);
		
		btnPanel.add(details); 
		
	}
	
	public void unClick() {
		btnPanel.setVisible(false);
		selected = false; 
		this.setSelected(false);
	}
}