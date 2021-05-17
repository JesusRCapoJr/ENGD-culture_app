import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
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
	private final int SHELL = 2;
	private JFrame frame; 
	private DesplayState1 desplayState;
	
	public TaskButton(Task task, JFrame frame) { 
		super(task.getTitle());
		this.task = task;
		this.frame = frame; 
		this.world = PandativityFrame.getWorld(); 
		this.setText(task.getTitle());
		this.createAction();
	}
	
	public TaskButton(JPanel world, Task task) {
		super(task.getTitle()); 
		this.world = world; 
		this.task = task; 
	}
	
	public TaskButton(JPanel world, Task task, double upperLeftX, double upperLeftY, double width, double height) {
		super(task.getTitle(), upperLeftX, upperLeftY, width, height); 
		this.world = world; 
		this.task = task; 
		this.details = new JTextArea(); 
		world.add(btnPanel); 
		selected = false; 
		//System.out.println("TaskButton Bounds: "+upperLeftX+", "+upperLeftY+", "+width+", "+height); 
	}
	
	public TaskButton(JPanel world, Task task, double upperLeftX, double upperLeftY, double width, double height, DesplayState1 desplayState, JFrame frame) {
		super(task.getTitle(), upperLeftX, upperLeftY, width, height); 
		this.world = world; 
		this.task = task; 
		this.details = new JTextArea(); 
		world.add(btnPanel); 
		selected = false; 
		this.desplayState=desplayState;
		this.frame = frame;
		//System.out.println("TaskButton Bounds: "+upperLeftX+", "+upperLeftY+", "+width+", "+height); 
	}

	@Override 
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("TaskButton triggered: "); 
				if(selected) {
					unClick(); 
				}else {
					HomeOverviewPanel.cleanAll();
					//displayTask(); 
					setSelected(true); 
					selected = true; 
		        	KieyaAddTaskTestWindow frame2 = new KieyaAddTaskTestWindow(task,false,desplayState,frame);
		        	frame2.setVisible(true);
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
		
		int l = FONT_SIZE*this.task.getDescriptionRows(width/2, FONT_SIZE)+16; 
		String choppedDescription = this.task.getDescriptionByRows(width, FONT_SIZE); 
		
		btnPanel.setBackground(Color.GRAY);
		btnPanel.setLayout(null);
		int theoraticalY = (int)upperLeftPosition.getY()-(l-height)/2-SHELL; 
		if(theoraticalY > 0 && theoraticalY+l+2*SHELL < world.getHeight()) {
			btnPanel.setBounds((int)(upperLeftPosition.getX()-width-SHELL-2), 
					theoraticalY, 
					width+2*SHELL, 
					l+2*SHELL);
		}else if(theoraticalY <= 0) {
			btnPanel.setBounds((int)(upperLeftPosition.getX()-width-SHELL-2), 
					0, 
					width+2*SHELL, 
					l+2*SHELL);
		}else {
			btnPanel.setBounds((int)(upperLeftPosition.getX()-width-SHELL-2), 
					theoraticalY - (world.getHeight() - (l+2*SHELL)), 
					width+2*SHELL, 
					l+2*SHELL);
		}
		
		//System.out.println("btnPanel Bounds: "+((int)upperLeftPosition.getX()-width)+", "+((int)upperLeftPosition.getY()-(l-height)/2)+", "+width+", "+l); 
		//world.add(btnPanel); 
		btnPanel.setVisible(true);  
		
		details.setBounds(SHELL,SHELL,width,l);
		details.setText("Description: "+choppedDescription);
		details.setBackground(Color.YELLOW);   
		details.setVisible(true);
		
		btnPanel.add(details); 
		
	}
	
	public void unClick() {
		btnPanel.setVisible(false);
		selected = false; 
		this.setSelected(false);
	}
}